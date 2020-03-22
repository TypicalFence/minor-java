package moe.zaun.prismriver.minor.dto;

public class StatusApiResponse extends AbstractApiResponse {
    public StatusApiResponse(int status, String msg) {
        this.setStatus(status);
        this.setMessage(msg);
    }

    public static StatusApiResponse badRequest() {
        return new StatusApiResponse(400, "bad_request");
    }

    public static StatusApiResponse notFound() {
        return new StatusApiResponse(404, "not_found");
    }

    public static StatusApiResponse internalError() {
        return new StatusApiResponse(500, "internal_error");
    }

    public static StatusApiResponse ok() {
        return new StatusApiResponse(200, "ok");
    }
}
