package models;

import java.util.HashSet;
import java.util.Set;


public class HttpRequestScheduleTask extends AbstractScheduleTask {
    private int id;
    private HttpMethod method;
    private String url;
    private Set<HttpHeaders> headers= new HashSet<>();
    private String data;
    private DataType dataType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<HttpHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(Set<HttpHeaders> headers) {
        this.headers = headers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "HttpRequestScheduleTask{" +
                "id=" + id +
                ", method=" + method +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", data='" + data + '\'' +
                ", dataType=" + dataType+super.toString()+'}';
    }
}
