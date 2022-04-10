package az.spring.rest.demo.springrestdemo.enums;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUND("Employee not found");
    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
