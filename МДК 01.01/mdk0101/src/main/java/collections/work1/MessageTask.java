package collections.work1;

import java.util.*;

public class MessageTask {
    public static void main(String[] args) {
        List<Message> list = new ArrayList<>();
        Priority[] priorities = Priority.values();
        Random rnd = new Random();

        for (int i = 0; i < 20; i++) {
            list.add(new Message(priorities[rnd.nextInt(4)], rnd.nextInt(10), "Msg" + i));
        }

        Set<Message> unique = new LinkedHashSet<>(list);
        System.out.println("Уникальные: " + unique);

        list.removeIf(m -> m.priority == Priority.LOW);

        Map<Priority, Integer> pCount = new HashMap<>();
        for (Message m : list) {
            pCount.put(m.priority, pCount.getOrDefault(m.priority, 0) + 1);
        }
        System.out.println("Статистика: " + pCount);
    }
}