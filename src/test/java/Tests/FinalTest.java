/*package Tests;

import Exceptions.IncorrectPasswordException;
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
            User user = User.getUser("Iron Man");
        } catch (UserNotFoundException | IncorrectPasswordException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("Customer",Database.getUserRole("Iron Man"));
    }

    @Test
    @DisplayName("UserNotFountExceptionThrown")
    public void testUserNotFoundExceptionisThrown() throws UserNotFoundException, IncorrectPasswordException, IOException, ParseException {
        //Database.setUp();
        Assertions.assertThrows(UserNotFoundException.class,
                () -> { User user = User.getUser("Iron", "this"); });
    }


    @Test
    @DisplayName("UserAlreadyExistsExceptionThrown")
    public void testGetUser() throws IOException, ParseException {
        Database.insertUser(new User("Wonder Woman","123","12343","email","Manager"));
        Assertions.assertEquals("123",Database.getUserPassword("Wonder Woman"));
    }



    @Test
    public void testName() {

        String s  = "Adrian Achim";
        Assertions.assertTrue(s.matches("^[A-Za-z]+.[A-Za-z]+$"));
    }

    @Test
    @DisplayName("IncorrectPasswordExceptionThrown")
    public void testIncorrectPasswordExceptionisThrown() throws IncorrectPasswordException, IOException, ParseException {
        //Database.setUp();
        Database.insertUser(new User("Ion","parola","07","email","Customer"));
        Assertions.assertThrows(IncorrectPasswordException.class,
                () -> { User user = User.getUser("Ion","parol"); });

    }
}*/
