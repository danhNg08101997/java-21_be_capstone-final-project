package com.cybersoft.newbalanceproject.dto.response;

public class BaseResponse {
    private int statusCode;
    private String message;
    private Object data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse(){
        this.data=null;
        this.message=null;
        this.statusCode=0;
    }
    public BaseResponse(Object data){this.data=data;}
    public BaseResponse(String message, int statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }
    public BaseResponse(Object data, String message, int statusCode){
        this.data=data;
        this.message=message;
        this.statusCode=statusCode;
    }
}
