package collections.work3;

import java.util.*;

public class PhoneBookTask {
    public static void main(String[] args) {
        TreeMap<String, String> book = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Имя или Номер:");
            String in = sc.nextLine();

            if (in.equals("LIST")) {
                for (var e : book.entrySet()) System.out.println(e.getKey() + " - " + e.getValue());
                continue;
            }

            if (in.matches("\\d+")) {
                if (book.containsValue(in)) {
                    for (String name : book.keySet()) {
                        if (book.get(name).equals(in)) System.out.println(name + ": " + in);
                    }
                } else {
                    System.out.println("Новый номер! Введите имя:");
                    book.put(sc.nextLine(), in);
                }
            } else {
                if (book.containsKey(in)) {
                    System.out.println(in + ": " + book.get(in));
                } else {
                    System.out.println("Новое имя! Введите номер:");
                    book.put(in, sc.nextLine());
                }
            }
        }
    }
}