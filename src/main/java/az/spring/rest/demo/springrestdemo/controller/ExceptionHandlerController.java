package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.exception.CustomNotFoundException;
import az.spring.rest.demo.springrestdemo.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomException(CustomNotFoundException e) {
        return ErrorResponse
                .builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInputParam(MethodArgumentTypeMismatchException e) {
        return ErrorResponse
                .builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(e.getParameter().getParameterName() + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException e){
        return ErrorResponse
                .builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(e.getBindingResult().getFieldError().getField() + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnkown(ExceptionHandler e){
        return ErrorResponse
                .builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
