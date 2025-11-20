package work1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageGenerator {
    public static List<Message> generateMessages(int count) {
        List<Message> messages = new ArrayList<>();
        Random random = new Random();
        Priority[] priorities = Priority.values();
        String[] texts = {"Login error", "System update", "New user", "Disk full", "Timeout"};

        for (int i = 0; i < count; i++) {
            messages.add(new Message(
                    priorities[random.nextInt(priorities.length)],
                    random.nextInt(10),
                    texts[random.nextInt(texts.length)]
            ));
        }
        return messages;
    }
}