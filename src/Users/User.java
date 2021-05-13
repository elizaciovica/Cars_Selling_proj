package Users;

import java.io.IOException;
import java.util.Objects;

import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import database.Database;

public class User
{
    private static String username, password, phone_number, email;

    public User(String username,String password,String phone_number,String email)
    {
        this.username=username;
        this.password=password;
        this.phone_number=phone_number;
        this.email=email;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(phone_number, user.phone_number) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, phone_number, email);
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User getUser(String name, String password) throws UserNotFoundException, IncorrectPasswordException {
        if(!Database.userExists(name)) {
            throw new UserNotFoundException("User" + name + "is not found");
        }
        if (!password.equals(Database.getUserPassword(name))) {
            throw new IncorrectPasswordException("Password incorrect");
        }
        /*if (Database.getUserMode(name).equals("client"))
            return new Customer(name, password, phone_number, email);
        else
            return new Manager(name, password, phone_number, email);*/
        return new User(name,password,phone_number,email);
    }



}