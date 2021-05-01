package database;

import Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Database {
    private static JSONObject data=new JSONObject();
    private static final String path ="Users.json";

    public static void setUp() throws IOException, ParseException {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        /*JSONParser js = new JSONParser();
        Object obj = null;
        try {
            obj = js.parse(reader);
            data = (JSONObject) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Object obj = new JSONParser().parse(reader);

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting firstName and lastName
        String phone = (String) jo.get("phone");
        String username = (String) jo.get("username");

        System.out.println(phone);
        System.out.println(username);

    }

    public static boolean insertUser(User user) {
        JSONObject userData = new JSONObject();
        userData.put("password", user.getPassword());
        userData.put("phone", user.getPhone_number());
        userData.put("email", user.getEmail());
        userData.put("username",user.getUsername());

        try (FileWriter file = new FileWriter("users.json",true)) {
            ObjectMapper mapper = new ObjectMapper();
            file.write(String.valueOf(userData));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //((JSONObject) data.get("user")).put(username, userData);
        return true;


    }

    public static void main(String[] args) throws IOException, ParseException {
       Database.insertUser(new User("ion","sulea","07","hatz@jonule.com"));
        Database.setUp();
    }
}
