package task1;

public class Users {
    private User[] massiv = new User[10];
    private int count = 0;
    private int nextId = 1;

    public void addUser(String name, int age, String gender) {
        if (count >= massiv.length) {
            System.out.println("Места нет");
            return;
        }
        massiv[count] = new User(nextId++, name, age, gender);
        count++;
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("Пользователей нет");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(massiv[i]);
        }
    }
}