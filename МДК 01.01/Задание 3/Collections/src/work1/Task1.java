package work1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<Message> messages = MessageGenerator.generateMessages(20);
        System.out.println("Все сообщения: " + messages);

        System.out.println("\n3. Уникальные сообщения:");
        System.out.println(getUniqueMessages(messages));

        System.out.println("\n4. Удаление LOW:");
        List<Message> copy1 = new ArrayList<>(messages);
        removeByPriority(copy1, Priority.LOW);

        System.out.println("\n5. Оставить только HIGH:");
        List<Message> copy2 = new ArrayList<>(messages);
        removeExceptPriority(copy2, Priority.HIGH);

        System.out.println("\n6. Подсчет по приоритетам:");
        countByPriority(messages);

        System.out.println("\n7. Подсчет по кодам:");
        countByCode(messages);

        System.out.println("\n8. Кол-во уникальных сообщений: " + new HashSet<>(messages).size());
    }

    public static List<Message> getUniqueMessages(List<Message> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void removeByPriority(List<Message> list, Priority p) {
        System.out.println("До: " + list);
        Iterator<Message> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() == p) {
                iterator.remove();
            }
        }
        System.out.println("После: " + list);
    }

    public static void removeExceptPriority(List<Message> list, Priority p) {
        System.out.println("До: " + list);
        Iterator<Message> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() != p) {
                iterator.remove();
            }
        }
        System.out.println("После: " + list);
    }

    public static void countByPriority(List<Message> list) {
        Map<Priority, Integer> counts = new HashMap<>();
        for (Message m : list) {
            counts.put(m.getPriority(), counts.getOrDefault(m.getPriority(), 0) + 1);
        }
        System.out.println(counts);
    }

    public static void countByCode(List<Message> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Message m : list) {
            counts.put(m.getCode(), counts.getOrDefault(m.getCode(), 0) + 1);
        }
        System.out.println(counts);
    }
}