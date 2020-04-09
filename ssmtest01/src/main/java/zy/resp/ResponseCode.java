package zy.resp;

/**
 * Created on 12/16/2019
 * Copyright by chenqb
 */
public class ResponseCode {

    private String code;

    private String message;

    public ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
