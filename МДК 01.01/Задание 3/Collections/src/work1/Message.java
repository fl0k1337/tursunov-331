package work1;

import java.util.Objects;

public class Message {
    private Priority priority;
    private int code;
    private String text;

    public Message(Priority priority, int code, String text) {
        this.priority = priority;
        this.code = code;
        this.text = text;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return code == message.code && priority == message.priority && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, code, text);
    }

    @Override
    public String toString() {
        return "{" + priority + ", code=" + code + ", '" + text + "'}";
    }
}