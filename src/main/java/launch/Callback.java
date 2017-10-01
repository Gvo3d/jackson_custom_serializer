package launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import models.HttpRequestScheduleTask;
import support.CallbackResponseDTO;
import support.HttpCallbackResponseSerializer;
import support.HttpTaskRequestSerializer;

public class Callback {
    public static void main(String[] args) {
        CallbackResponseDTO dto = new CallbackResponseDTO(12345678, 200, "bsdkjfbsdkjcsdbfdsjk");

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(CallbackResponseDTO.class, new HttpCallbackResponseSerializer());
        mapper.registerModule(module);

        try {
            System.out.println(mapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
