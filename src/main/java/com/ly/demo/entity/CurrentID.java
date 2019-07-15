package com.ly.demo.entity;

public class CurrentID {
    private Integer id;

    private Integer currentid;

    private String agent;

    private Integer onoff;

    private Integer groupsize;

    public Integer getGroupsize() {
        return groupsize;
    }

    public void setGroupsize(Integer groupsize) {
        this.groupsize = groupsize;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getOnoff() {
        return onoff;
    }

    public void setOnoff(Integer onoff) {
        this.onoff = onoff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentid() {
        return currentid;
    }

    public void setCurrentid(Integer currentid) {
        this.currentid = currentid;
    }
}