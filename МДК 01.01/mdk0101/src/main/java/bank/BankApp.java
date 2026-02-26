package bank;

import database.DatabaseManager;
import javax.swing.*;
import java.awt.*;

public class BankApp extends JFrame {
    private JTextField f1 = new JTextField(10), f2 = new JTextField(10), f3 = new JTextField(10);
    private JTextArea log = new JTextArea(10, 30);

    public BankApp() {
        DatabaseManager.initTables();
        setTitle("Банк");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Счет:")); add(f1);
        add(new JLabel("Кому:")); add(f2);
        add(new JLabel("Сумма:")); add(f3);

        JButton b1 = new JButton("Оплатить");
        JButton b2 = new JButton("Перевод");
        JButton b3 = new JButton("Создать клиентов");

        add(b1); add(b2); add(b3); add(new JScrollPane(log));

        b1.addActionListener(e -> {
            try { log.append(BankService.pay(f1.getText(), Double.parseDouble(f3.getText())) + "\n"); }
            catch (Exception ex) { log.append(ex.getMessage() + "\n"); }
        });

        b2.addActionListener(e -> {
            try {
                BankService.transferMoney(f1.getText(), f2.getText(), Double.parseDouble(f3.getText()));
                log.append("Перевод выполнен\n");
            } catch (Exception ex) { log.append("Ошибка перевода\n"); }
        });

        b3.addActionListener(e -> {
            for(int i=1; i<=5; i++) {
                BankService.addAccount("100"+i, "Base"+i, 5000, "Base");
                BankService.addAccount("200"+i, "VIP"+i, 50000, "VIP");
            }
            log.append("Клиенты добавлены\n");
        });

        pack(); setVisible(true);
    }
    public static void main(String[] args) { new BankApp(); }
}