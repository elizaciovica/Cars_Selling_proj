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
import java.util.Iterator;

public class Database {
    private static JSONObject data = new JSONObject();
    private static JSONArray users = new JSONArray();
    private static final String path = "Users.json";


    public static void setUp() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("users.json")) {

            JSONArray array = (JSONArray) parser.parse(reader);
            System.out.println(array);


        }
    }


    public static boolean insertUser(User user) {
        JSONObject userData = new JSONObject();
        userData.put("password", user.getPassword());
        userData.put("phone", user.getPhone_number());
        userData.put("email", user.getEmail());
        userData.put("username", user.getUsername());
        users.add(userData);

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
}

