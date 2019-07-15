package com.ly.demo.entity;

import java.util.Date;

public class ErrorLog {
    private Integer id;

    private String agent;

    private String currentid;

    private Date createtime;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    private Integer result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getCurrentid() {
        return currentid;
    }

    public void setCurrentid(String currentid) {
        this.currentid = currentid == null ? null : currentid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}