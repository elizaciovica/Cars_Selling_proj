package Tests;

import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import Users.User;
import database.Database;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class FinalTest {
    @Test
    public void TestLogin() throws IOException, ParseException {
        Database.insertUser(new User("Iron Man","1","112","mail","Customer"));
        Database.writeUsersArray();

        try {
            User user = User.getUser("Iron Man","1");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testUserNotFoundExceptionisThrown() throws UserNotFoundException, IncorrectPasswordException, IOException, ParseException {
        Database.setUp();
        Assertions.assertThrows(UserNotFoundException.class,
                () -> { User user = User.getUser("Hulk", "bere"); });
    }
}
