package DataDriven;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Implementation_JsonDataReader {
    public String UserName ,PassWord,UserNameForAddUser,employeeName;
    public void jsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/main/java/DataDriven/UserData.json";
        File srcFile = new File(filePath);
        JSONParser json_parser = new JSONParser();
        JSONArray json_Array = (JSONArray) json_parser.parse(new FileReader(srcFile));
        for (Object jsonObj : json_Array){
            JSONObject person = (JSONObject) jsonObj;

            UserName = (String) person.get("UserName");
            PassWord = (String) person.get("PassWord");
            UserNameForAddUser = (String) person.get("UserNameForAddUser");
            employeeName = (String) person.get("employeeName");
        }
    }

}