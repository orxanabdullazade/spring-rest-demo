package az.spring.rest.demo.springrestdemo.enums;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUND(1001,"Employee not found"),
    VALIDATION_ERROR(1002," is not valid"),
    UNKNOWN_ERROR(1000," unkown error");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code,String message) {
        this.code=code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public int getCode() { return code; }
}
