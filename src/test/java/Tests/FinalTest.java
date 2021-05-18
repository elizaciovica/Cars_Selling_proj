package Tests;

import Exceptions.IncorrectPasswordException;
import Exceptions.UserAlreadyExistsException;
import Exceptions.UserNotFoundException;
import Users.User;
import database.Database;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class FinalTest {
    @Test
    @DisplayName("Registratin Test")
    public void TestRegistration() throws IOException, ParseException {
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
    @DisplayName("UserNotFountExceptionThrown")
    public void testUserNotFoundExceptionisThrown() throws UserNotFoundException, IncorrectPasswordException, IOException, ParseException {
        Database.setUp();
        Assertions.assertThrows(UserNotFoundException.class,
                () -> { User user = User.getUser("Iron", "this"); });
    }

    @Test
    @DisplayName("UserAlreadyExistsExceptionThrown")
    public void testUserAlreadyExistsExceptionisThrown() throws UserAlreadyExistsException, IOException, ParseException {
        Database.setUp();
        Assertions.assertThrows(UserAlreadyExistsException.class,
                () -> { User user = User.getUser("Wonder Woman","123"); });

    }

    @Test
    @DisplayName("IncorrectPasswordExceptionThrown")
    public void testIncorrectPasswordExceptionisThrown() throws IncorrectPasswordException, IOException, ParseException {
        Database.setUp();
        Assertions.assertThrows(IncorrectPasswordException.class,
                () -> { User user = User.getUser("Timon","Pumba"); });

    }
}
