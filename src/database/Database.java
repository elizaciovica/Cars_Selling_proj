package database;

import Users.*;
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
    private static JSONObject data = new JSONObject();
    private static JSONArray users = new JSONArray();
    private static final String path = "Users.json";

    public static void setUp() throws IOException, ParseException {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


        JSONParser js = new JSONParser();
        Object obj = null;
        try {
            obj = js.parse(reader);
            data = (JSONObject) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public static boolean insertUser(User user) {
        JSONObject userData = new JSONObject();
        userData.put("password", user.getPassword());
        userData.put("phone", user.getPhone_number());
        userData.put("email", user.getEmail());
        userData.put("username", user.getUsername());

        try (FileWriter file = new FileWriter("users.json", true)) {
            ObjectMapper mapper = new ObjectMapper();
            users.add(userData);
            //file.write(String.valueOf(users));
            //file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //((JSONObject) data.get("user")).put(username, userData);
        return true;


    }

    public static void writeUsersArray() throws IOException {
        try (FileWriter file = new FileWriter("users.json", true)) {
            file.write(String.valueOf(users));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

