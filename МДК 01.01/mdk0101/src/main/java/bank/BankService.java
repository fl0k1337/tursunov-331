package bank;

import database.DatabaseManager;
import java.sql.*;

public class BankService {
    public static void addAccount(String n, String name, double b, String t) {
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT OR REPLACE INTO accounts VALUES (?,?,?,?,1)");
            ps.setString(1, n); ps.setString(2, name); ps.setDouble(3, b); ps.setString(4, t);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static String pay(String num, double amount) throws Exception {
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE num=?");
            ps.setString(1, num);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return "Нет счета";

            double bal = rs.getDouble("balance");
            String type = rs.getString("type");
            boolean isFirst = rs.getInt("first") == 1;
            if (bal < amount) throw new Exception("Мало денег");

            double cb = 0;
            if (type.equals("Base") && amount >= 10000) cb = amount * 0.01;
            else if (type.equals("Premium") && amount >= 10000) cb = amount * 0.05;
            else if (type.equals("VIP")) {
                if (amount < 10000) cb = amount * 0.01;
                else if (amount < 100000) cb = amount * 0.05;
                else cb = amount * 0.10;
            }

            double newBal = bal - amount + cb + (isFirst ? 1000 : 0);
            PreparedStatement up = conn.prepareStatement("UPDATE accounts SET balance=?, first=0 WHERE num=?");
            up.setDouble(1, newBal); up.setString(2, num);
            up.executeUpdate();
            return "Ок. Баланс: " + newBal;
        }
    }

    public static void transferMoney(String f, String t, double a) throws Exception {
        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);
            try (Statement s = conn.createStatement()) {
                s.executeUpdate("UPDATE accounts SET balance=balance-"+a+" WHERE num='"+f+"'");
                s.executeUpdate("UPDATE accounts SET balance=balance+"+a+" WHERE num='"+t+"'");
                conn.commit();
            } catch (Exception e) { conn.rollback(); throw e; }
        }
    }
}