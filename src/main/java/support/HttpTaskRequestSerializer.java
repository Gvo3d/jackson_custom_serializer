package support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import models.HttpHeaders;
import models.HttpRequestScheduleTask;

import java.io.IOException;

public class HttpTaskRequestSerializer extends StdSerializer<HttpRequestScheduleTask> {
    private DateTimeJsonParser dateParser = new DateTimeJsonParser();
    private NextRunTaskParser nextDateParser = new NextRunTaskParser(dateParser);

    public HttpTaskRequestSerializer() {
        super(HttpRequestScheduleTask.class);
    }

    public HttpTaskRequestSerializer(Class<HttpRequestScheduleTask> t) {
        super(t);
    }

    @Override
    public void serialize(HttpRequestScheduleTask httpRequestScheduleTask, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.useDefaultPrettyPrinter();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("body");
        jsonGenerator.writeFieldName("job_id");
        jsonGenerator.writeString(String.valueOf(httpRequestScheduleTask.getId()));
        jsonGenerator.writeObjectFieldStart("task");
        jsonGenerator.writeFieldName("method");
        jsonGenerator.writeString(httpRequestScheduleTask.getMethod().toString());
        jsonGenerator.writeFieldName("url");
        jsonGenerator.writeString(httpRequestScheduleTask.getUrl());
        jsonGenerator.writeObjectFieldStart("headers");
        for (HttpHeaders header : httpRequestScheduleTask.getHeaders()) {
            jsonGenerator.writeFieldName(header.getKey().getKey());
            jsonGenerator.writeString(header.getValue().getValue());
        }
        jsonGenerator.writeEndObject();
        if (httpRequestScheduleTask.getData() != null) {
            jsonGenerator.writeObjectField("data", httpRequestScheduleTask.getData());
        } else {
            jsonGenerator.writeObjectFieldStart("data");
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
        jsonGenerator.writeFieldName("type");
        jsonGenerator.writeString(httpRequestScheduleTask.getType());
        jsonGenerator.writeFieldName("scheduled_at");
        jsonGenerator.writeString(httpRequestScheduleTask.getSchedulet_at());
        jsonGenerator.writeFieldName("execute_times");
        jsonGenerator.writeNumber(httpRequestScheduleTask.getExecute_times());
        jsonGenerator.writeFieldName("start_time");
        jsonGenerator.writeString(dateParser.parseDateToString(httpRequestScheduleTask.getStart_time()));
        jsonGenerator.writeFieldName("end_time");
        jsonGenerator.writeString(dateParser.parseDateToString(httpRequestScheduleTask.getEnd_time()));
        jsonGenerator.writeFieldName("time_zone");
        jsonGenerator.writeString(httpRequestScheduleTask.getTime_zone());
        jsonGenerator.writeFieldName("callback_url");
        jsonGenerator.writeString(httpRequestScheduleTask.getCallback_url());

        jsonGenerator.writeFieldName("next_run_at");
        jsonGenerator.writeString(nextDateParser.getNextRunTime(httpRequestScheduleTask.getSchedulet_at()));
        jsonGenerator.writeFieldName("last_run_at");
        jsonGenerator.writeString(dateParser.parseDateToString(httpRequestScheduleTask.getLast_run_at()));
        jsonGenerator.writeObjectFieldStart("last_run_result");
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeNumber(httpRequestScheduleTask.getLastRunCode());
        jsonGenerator.writeFieldName("body");
        jsonGenerator.writeString(httpRequestScheduleTask.getLastRunResult());
        jsonGenerator.writeEndObject();
    }
}
