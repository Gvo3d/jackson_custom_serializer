package launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import models.HttpRequestScheduleTask;
import support.HttpTaskCreationResponseSerializer;
import support.HttpTaskRequestSerializer;
import support.HttpTaskResponseDTO;

public class Creation {
    public static void main(String[] args) {
        Integer id = 12345678;

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Integer.class, new HttpTaskCreationResponseSerializer());
        mapper.registerModule(module);

        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
