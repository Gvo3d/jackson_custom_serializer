package support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import models.HttpRequestScheduleTask;

import java.io.IOException;

public class HttpCallbackResponseSerializer extends StdSerializer<CallbackResponseDTO> {

    public HttpCallbackResponseSerializer() {
        super(CallbackResponseDTO.class);
    }

    public HttpCallbackResponseSerializer(Class<CallbackResponseDTO> t) {
        super(t);
    }

    @Override
    public void serialize(CallbackResponseDTO callbackResponseDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.useDefaultPrettyPrinter();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("body");
        jsonGenerator.writeFieldName("job_id");
        jsonGenerator.writeString(String.valueOf(callbackResponseDTO.getJobId()));
        jsonGenerator.writeObjectFieldStart("result");
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeNumber(callbackResponseDTO.getCode());
        jsonGenerator.writeFieldName("body");
        jsonGenerator.writeString(String.valueOf(callbackResponseDTO.getBody()));
        jsonGenerator.writeEndObject();
    }
}
