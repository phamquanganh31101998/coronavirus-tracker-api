package com.example.demo.contracts;

public class ResponseContract <T>{
    private String code;
    private int status;
    private String message;
    private T response;

    public ResponseContract(String code, int status, String message, T response) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getResponse() {
        return response;
    }
    public void setResponse(T response) {
        this.response = response;
    }
}
