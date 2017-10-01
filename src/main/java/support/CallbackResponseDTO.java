package support;

public class CallbackResponseDTO {
    private int jobId;
    private int code;
    private String body;

    public CallbackResponseDTO(int jobId, int code, String body) {
        this.jobId = jobId;
        this.code = code;
        this.body = body;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
