package com.grq.bean;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {
    public final static int SUCCESS=200;
    public final static int FAIL=500;
    private int status;
    private String message;
    private T data;

    public BaseResult() {
    }

    public BaseResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
