package work2;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        TreeSet<String> emails = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("LIST")) {
                for (String email : emails) {
                    System.out.println(email);
                }
            } else if (input.startsWith("ADD ")) {
                String email = input.substring(4).trim();
                if (pattern.matcher(email).matches()) {
                    emails.add(email);
                } else {
                    System.out.println("Ошибка: Некорректный формат email");
                }
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }
}