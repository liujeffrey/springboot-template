package com.example.template.response;

public class Response {
    private static final String OK = "ok";

    private static final String ERROR = "error";

    private Meta meta;    //元数据

    private Object data;  //响应数据

    public Response success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String messsage) {
        this.meta = new Meta(false, messsage);
        return this;
    }

    public Response failure(String message, Object data) {
        this.meta = new Meta(false, message);
        this.data = data;
        return this;
    }


    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return meta.toString();
    }
}
