package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public static Result newsuccess(String msg) {
        log.info(msg);
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(T data) {
        log.info(data.toString());
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> newsuccess(T data ,String msg) {
        log.info(msg +"----"+ data.toString());
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg(msg);
        return result;
    }
    public static Result error(String code, String msg) {
        log.error(msg);
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

