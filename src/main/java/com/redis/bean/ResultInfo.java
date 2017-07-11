package com.redis.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Movie on 2017/7/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T> {
    private static final int OK = 0;
    private static final int ERROR = 100;

    private int code;
    private String msg;
    private String url;
    private T Data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
