package database;

import Users.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class Database {

    private static JSONObject data;
    private static JSONArray users = new JSONArray();
    private static final String path = "Users.json";
    public static ArrayList<User> list= new ArrayList<>(10);


    public static void setUp() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Reader reader = new FileReader("users.json") ;

            JSONArray array = (JSONArray) parser.parse(reader);
            for (int i = 0; i < array.size(); i++) {
                    data= (JSONObject) array.get(i);
                String username = data.getString("username");
                String email = data.getString("email");
                String phone = data.getString("phone");
                String password = data.getString("password");
                String role=data.getString("role");
                System.out.println(data);
                list.add(new User(username, password, phone, email,role));
                data.put("password", username);
                data.put("phone", phone);
                data.put("email", email);
                data.put("username", username);
                users.add(data);

            }
        }



    public static boolean insertUser(User user) throws IOException, ParseException {
        JSONObject userData = new JSONObject();
        userData.put("password", user.getPassword());
        userData.put("phone", user.getPhone_number());
        userData.put("email", user.getEmail());
        userData.put("username", user.getUsername());
        userData.put("role",user.getRole());
        users.add(userData);
        list.add(user);

        return true;


    }

    public static void writeUsersArray() throws IOException {
        try (FileWriter file = new FileWriter("users.json")) {
            file.write(users.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User getUserData(String user) {
        for(User u : list)
        {
            if(u.getUsername().equals(user))
                return u;
        }
        return null;
    }


    public static Boolean userExists(String user) {
        /*if(getUserData(user) == null)
            return false;
        return true;*/
        for(User u : list)
        {
            if(u.getUsername().equals(user))
                return true;
        }
        return false;
    }

    public static String getUserPassword(String user) {
            return getUserData(user).getPassword();

    }

    public static String getUserEmail(String user) {

            return getUserData(user).getEmail();
    }

    public static String getUserPhone(String user) {

        return getUserData(user).getPhone_number();
    }

    public static String getUserRole(String user) {

        return getUserData(user).getRole();
    }


    /*public static String getUserMode(String user) {
        JSONObject userData = getUserData(user);
        if (userData == null)
            return null;
        return (String) userData.get("mode");

    }*/

}

