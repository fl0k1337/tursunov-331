import org.junit.jupiter.api.Test;
import task1.Users;

public class UsersTest {

    @Test
    public void testAddAndPrintUsers() {
        Users users = new Users();
        users.addUser("danya", 18, "мужской");
        users.addUser("igor", 18, "мужской");

        users.printAll();
    }
}