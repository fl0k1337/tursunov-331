package database;

import java.sql.*;

public class DatabaseManager {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:system.db");
    }

    public static void initTables() {
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS accounts (num TEXT PRIMARY KEY, name TEXT, balance REAL, type TEXT, first INTEGER)");
            st.execute("CREATE TABLE IF NOT EXISTS fitness (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT)");
        } catch (Exception e) { e.printStackTrace(); }
    }
}