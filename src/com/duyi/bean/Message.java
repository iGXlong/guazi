package com.duyi.bean;

import com.google.gson.Gson;

public class Message {
    private String result;
    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Message() {
    }

    public Message(String result, Object data) {
        this.result = result;
        this.data = data;
    }

    public Message(String result) {
        this.result = result;
    }

    public String toJSON(){
        return new Gson().toJson(this);
    }
}
