package launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import support.HttpTaskResponseDTO;

public class Response {
    public static void main(String[] args) {
        HttpTaskResponseDTO dto = new HttpTaskResponseDTO(200, "testmessage");

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
