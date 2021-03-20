import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonExample {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        User user = new User();
        user.name = "Jan Kowalski";
        user.age = 23;
        System.out.println(user.toString());

        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        try {
            //Object to JSON in file
            mapper.writeValue(new File("user.json"), user);

            //Object to JSON in String
            String jsonInString = mapper.writeValueAsString(user);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        try {

            // Convert JSON string from file to Object
            User user2 = mapper.readValue(new File("user.json"), User.class);
            System.out.println(user2.toString());

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    }

}