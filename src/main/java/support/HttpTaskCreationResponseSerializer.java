package support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import models.HttpRequestScheduleTask;

import java.io.IOException;

public class HttpTaskCreationResponseSerializer extends StdSerializer<Integer> {

    public HttpTaskCreationResponseSerializer() {
        super(Integer.class);
    }

    public HttpTaskCreationResponseSerializer(Class<Integer> t) {
        super(t);
    }

    @Override
    public void serialize(Integer integer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("body");
        jsonGenerator.writeFieldName("job_id");
        jsonGenerator.writeString(String.valueOf(integer));
        jsonGenerator.writeEndObject();
    }
}
