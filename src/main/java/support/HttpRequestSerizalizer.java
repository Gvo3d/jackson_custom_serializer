package support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import models.HttpRequestScheduleTask;

import java.io.IOException;

public class HttpRequestSerizalizer extends StdSerializer<HttpRequestScheduleTask> {

    protected HttpRequestSerizalizer() {
        super(HttpRequestScheduleTask.class);
    }

    @Override
    public void serialize(HttpRequestScheduleTask task, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
    }
}
