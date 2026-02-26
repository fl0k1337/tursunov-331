package fitness;

import javax.swing.*;
import java.awt.*;

public class FitnessApp extends JFrame {
    public FitnessApp() {
        setTitle("Фитнес");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField nameF = new JTextField(10);
        JComboBox<String> tBox = new JComboBox<>(new String[]{"разовый", "дневной", "полный"});
        JComboBox<String> zBox = new JComboBox<>(new String[]{"зал", "бассейн", "групповые"});
        JTextArea res = new JTextArea(10, 30);
        JButton btn = new JButton("Вход");

        add(new JLabel("Имя:")); add(nameF);
        add(tBox); add(zBox); add(btn); add(new JScrollPane(res));

        btn.addActionListener(e -> {
            res.append(FitnessService.canEnter(nameF.getText(), (String)tBox.getSelectedItem(), (String)zBox.getSelectedItem()) + "\n");
        });

        pack(); setVisible(true);
    }
    public static void main(String[] args) { new FitnessApp(); }
}