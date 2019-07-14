package com.ly.demo.utils;

public class JsonData {
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    private String ip;
    private String ua;

    public JsonData(String ip, String ua) {
        this.ip = ip;
        this.ua = ua;
    }

    public JsonData() {

    }

}
