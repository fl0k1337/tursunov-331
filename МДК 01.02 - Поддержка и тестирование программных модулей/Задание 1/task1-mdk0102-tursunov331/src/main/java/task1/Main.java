package task1;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        users.addUser("ivan ivan", 20, "мужской");
        users.addUser("danya danya", 19, "мужской");
        users.addUser("igor igor", 21, "мужской");

        users.printAll();
    }
}