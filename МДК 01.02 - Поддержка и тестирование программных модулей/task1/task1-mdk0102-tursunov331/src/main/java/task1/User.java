package task1;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final String gender;

    public User(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() { return id; }
    @Override
    public String toString() {
        return "ID=" + id + ", имя=" + name + ", возраст=" + age + ", пол=" + gender;
    }
}