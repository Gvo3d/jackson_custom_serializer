package models;

public class HttpHeaders {
    private int id;
    private HttpHeadersKey key;
    private HttpHeadersValue value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HttpHeadersKey getKey() {
        return key;
    }

    public void setKey(HttpHeadersKey key) {
        this.key = key;
    }

    public HttpHeadersValue getValue() {
        return value;
    }

    public void setValue(HttpHeadersValue value) {
        this.value = value;
    }
}
