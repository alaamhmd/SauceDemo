package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JSONDataReader {
    public String vUsername, homePageURL, mail, vPassword;

    public void jsonReader() throws FileNotFoundException, IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));


        for (Object jsonObj : jArray) {

            JSONObject user = (JSONObject) jsonObj;
            vUsername = (String) user.get("validUserName");
            //System.out.println(vUsername);
            vPassword = (String) user.get("validPassword");
            //System.out.println(vPassword);
            homePageURL = (String) user.get("homePageURL");

        }

    }
}

