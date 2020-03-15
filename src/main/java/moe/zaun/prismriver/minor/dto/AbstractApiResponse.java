package moe.zaun.prismriver.minor.dto;

public class AbstractApiResponse implements ApiResponse {

    private int status;
    private String msg;
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
