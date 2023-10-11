package enums;

public enum ResponseStatus {

    OK(200),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502);

    ResponseStatus(int i) {}
}