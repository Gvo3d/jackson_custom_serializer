package launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import models.*;
import support.HttpTaskRequestSerializer;
import support.DateTimeJsonParser;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DateTimeJsonParser dateParser = new DateTimeJsonParser();


        HttpRequestScheduleTask task = new HttpRequestScheduleTask();
        task.setId(12345678);
        task.setMethod(HttpMethod.POST);
        Set<HttpHeaders> headers = new HashSet<>();

        HttpHeaders headers1 = new HttpHeaders();
        HttpHeadersKey key1 = new HttpHeadersKey();
        key1.setKey("Content-Type");
        HttpHeadersValue value1 = new HttpHeadersValue();
        value1.setValue("application/json");
        headers1.setKey(key1);
        headers1.setValue(value1);
        headers.add(headers1);

        HttpHeaders headers2 = new HttpHeaders();
        HttpHeadersKey key2 = new HttpHeadersKey();
        key2.setKey("Accept");
        HttpHeadersValue value2 = new HttpHeadersValue();
        value2.setValue("application/json");
        headers2.setKey(key2);
        headers2.setValue(value2);
        headers.add(headers2);

        HttpHeaders headers3 = new HttpHeaders();
        HttpHeadersKey key3 = new HttpHeadersKey();
        key3.setKey("Authorization");
        HttpHeadersValue value3 = new HttpHeadersValue();
        value3.setValue("Bearer XXXXXX");
        headers3.setKey(key3);
        headers3.setValue(value3);
        headers.add(headers3);

        task.setHeaders(headers);
        task.setData("herhdrbhdfbwerhoiwehceilhcweoighseuohcvkljvhsdlfkjhelifvhsdjlvhsdlvhsdlv");
        task.setDataType(DataType.STRING);
        task.setType("http");
        task.setSchedulet_at("* */10 * ? * 2-6");
        task.setExecute_times(10);
        task.setStart_time(dateParser.parseStringToDate("2017-02-01 12:00:00"));
        task.setEnd_time(dateParser.parseStringToDate("2018-02-01 12:00:00"));
        task.setTime_zone("Asia/Singapore");
        task.setCallback_url("https://result.com/callback");
        task.setLast_run_at(dateParser.parseStringToDate("2017-02-01 12:10:00"));
        task.setEnabled(true);
        task.setLastRunCode(200);
        task.setLastRunResult("jfksdjkfbsdkjfbsdfkjsdb");


        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(HttpRequestScheduleTask.class, new HttpTaskRequestSerializer());
        mapper.registerModule(module);

        try {
            System.out.println(mapper.writeValueAsString(task));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
