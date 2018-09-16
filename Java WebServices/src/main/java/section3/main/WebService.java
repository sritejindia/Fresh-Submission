package section3.main;

import java.util.Map;
import spark.Spark;
import com.fasterxml.jackson.databind.ObjectMapper;
import section3.backend.CharacterCount;

public class WebService {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        System.out.println("The program is running");
        Spark.get("/main", (req, res) -> {
            try {
                String value = req.queryMap("value").value();
                value = (value == null ? "": value);
                Map<Character, Integer> map = CharacterCount.countCharacters(value);
                return mapper.writeValueAsString(map);
            } catch (Exception e) {
                e.printStackTrace();
                return "Do something good";
            }
        });
    }
}
