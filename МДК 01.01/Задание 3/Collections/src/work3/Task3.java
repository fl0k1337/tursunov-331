package work3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task3 {
    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя, номер или LIST:");
            String input = scanner.nextLine().trim();

            if (input.equals("LIST")) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                continue;
            }

            if (input.matches("\\d+")) {
                String name = null;
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    if (entry.getValue().equals(input)) {
                        name = entry.getKey();
                        break;
                    }
                }

                if (name != null) {
                    System.out.println("Контакт: " + name + " - " + input);
                } else {
                    System.out.println("Введите имя для номера " + input + ":");
                    String newName = scanner.nextLine().trim();
                    phoneBook.put(newName, input);
                    System.out.println("Контакт сохранен.");
                }

            } else {
                if (phoneBook.containsKey(input)) {
                    System.out.println("Контакт: " + input + " - " + phoneBook.get(input));
                } else {
                    System.out.println("Введите номер для " + input + ":");
                    String newPhone = scanner.nextLine().trim();
                    if (newPhone.matches("\\d+")) {
                        phoneBook.put(input, newPhone);
                        System.out.println("Контакт сохранен.");
                    } else {
                        System.out.println("Ошибка: номер должен содержать только цифры.");
                    }
                }
            }
        }
    }
}