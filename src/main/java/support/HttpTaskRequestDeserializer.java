package support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import models.*;


import java.io.IOException;
import java.util.*;

public class HttpTaskRequestDeserializer extends StdDeserializer<HttpRequestScheduleTask> {
    private DateTimeJsonParser dateParser = new DateTimeJsonParser();

    public HttpTaskRequestDeserializer(Class<?> vc) {
        super(vc);
    }

    public HttpTaskRequestDeserializer() {
        super(HttpRequestScheduleTask.class);
    }

    @Override
    public HttpRequestScheduleTask deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<String> errors = new ArrayList<>();
        HttpRequestScheduleTask task = new HttpRequestScheduleTask();
        JsonNode allNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode bodyNode = (JsonNode) getNodeData(allNode, "body", JsonType.JSON_NODE, errors,null);

        JsonNode taskNode = (JsonNode) getNodeData(bodyNode, "task", JsonType.JSON_NODE, errors,null);
        task.setMethod(HttpMethod.valueOf((String) getNodeData(taskNode, "method", JsonType.STRING, errors,null)));
        task.setUrl((String) getNodeData(taskNode, "url", JsonType.STRING, errors,null));
        Set<HttpHeaders> headers = new HashSet<>();
        if (!taskNode.get("headers").isMissingNode()) {
            Iterator<Map.Entry<String, JsonNode>> iterator = taskNode.get("headers").fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                HttpHeaders header = new HttpHeaders();
                HttpHeadersKey key = new HttpHeadersKey();
                key.setKey(entry.getKey());
                HttpHeadersValue value = new HttpHeadersValue();
                value.setValue(entry.getValue().asText());
                header.setKey(key);
                header.setValue(value);
                headers.add(header);
            }
        }
        task.setHeaders(headers);
        if (!taskNode.get("data").isMissingNode()) {
            task.setData((String) getNodeData(taskNode, "data", JsonType.STRING, errors,null));
        } else {
            task.setData(null);
        }

        task.setType((String) getNodeData(bodyNode, "type", JsonType.STRING, errors,"http"));
        task.setSchedulet_at((String) getNodeData(bodyNode, "scheduled_at", JsonType.STRING, errors,null));
        if (!bodyNode.get("execute_times").isMissingNode()) {
            task.setExecute_times((Integer) getNodeData(bodyNode, "execute_times", JsonType.INTEGER, errors, null));
        } else {
            task.setExecute_times(null);
        }
        task.setStart_time(dateParser.parseStringToDate((String) getNodeData(bodyNode, "start_time", JsonType.STRING, errors, dateParser.parseDateToString(new Date(System.currentTimeMillis())))));
        if (!bodyNode.get("end_time").isMissingNode()) {
            task.setEnd_time(dateParser.parseStringToDate((String) getNodeData(bodyNode, "end_time", JsonType.STRING, errors,null)));
        } else {
            task.setEnd_time(null);
        }
        task.setTime_zone((String) getNodeData(bodyNode, "time_zone", JsonType.STRING, errors,"Asia/Singapore"));
        if (!bodyNode.get("callback_url").isMissingNode()) {
            task.setCallback_url(bodyNode.get("callback_url").asText());
        }
        task.setEnabled(true);
        if (!errors.isEmpty()){
            StringBuilder builder = new StringBuilder();
            for (String msg: errors){
                builder.append(msg).append('\n');
            }
            deserializationContext.instantiationException(IllegalAccessException.class, builder.toString());
        }
        return task;
    }

    private Object getNodeData(JsonNode node, String fieldName, JsonType type, List<String> errors, Object defaultValue) {
        if (node.get(fieldName).isMissingNode()) {
            if (defaultValue!=null){
                return defaultValue;
            }
            errors.add("No \"" + fieldName + "\" tag in JSON, but required with type" + type);
        } else {
            JsonNode target = node.get(fieldName);
            switch (type) {
                case STRING: {
                    if (!target.isTextual()) {
                        errors.add("Value of \"" + fieldName + "\" tag in JSON, was bound to be a text, but is not");
                        return null;
                    }
                    return target.asText();
                }
                case INTEGER: {
                    if (!target.isNumber()) {
                        errors.add("Value of \"" + fieldName + "\" tag in JSON, was bound to be a number, but is not");
                        return null;
                    }
                    return ((IntNode) node.get(fieldName)).numberValue();
                }
                case JSON_NODE: {
                    if (!target.isContainerNode()) {
                        errors.add("Value of \"" + fieldName + "\" tag in JSON, was bound to be an inner node with it's own data context, but is not");
                        return null;
                    }
                    return target;
                }
            }
        }
        return null;
    }

    private enum JsonType {STRING, INTEGER, JSON_NODE}
}

