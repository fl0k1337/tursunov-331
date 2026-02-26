package collections.work2;

import java.util.*;

public class EmailTask {
    public static void main(String[] args) {
        Set<String> emails = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("LIST")) {
                System.out.println(emails);
            } else if (input.startsWith("ADD ")) {
                String mail = input.substring(4).toLowerCase();
                if (mail.contains("@") && mail.contains(".")) {
                    emails.add(mail);
                } else {
                    System.out.println("Ошибка формата");
                }
            }
        }
    }
}