package Users;

import java.io.IOException;
import java.util.Objects;

import Exceptions.CarAlreadyExists;
import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import database.Cryptography;
import database.Database;
import org.json.simple.parser.ParseException;

public class User
{
    private static String username, password, phone_number, email,role;

    public User(String username,String password,String phone_number,String email,String role)
    {
        this.username=username;
        this.password=password;
        this.phone_number=phone_number;
        this.email=email;
        this.role=role;

    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
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

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static User getUser(String name, String password) throws UserNotFoundException, IncorrectPasswordException {
        if(!Database.userExists(name)) {
            throw  new UserNotFoundException("User " + name + " is not found");
        }
        if (!Cryptography.getMD5(password).equals(Database.getUserPassword(name))) {
            throw new IncorrectPasswordException("Password incorrect"+Database.getUserPassword(name));
        }
        if (Database.getUserRole(name).equals("Customer"))
            return new Customer(name, password, phone_number, email,role);
        else
            return new Manager(name, password, phone_number, email,role);
        //return new User(name,password,phone_number,email,role);
    }

    public static void main(String[] args) throws UserNotFoundException, IncorrectPasswordException, IOException, ParseException, CarAlreadyExists {

        //Database.insertUser(new User("alex","parola","09","adsf"));
        //Database.writeUsersArray();
        Database.setUp();
        //System.out.println(getUser("alex","parola"));
        //System.out.println(getUser("1","2"));
    }

}