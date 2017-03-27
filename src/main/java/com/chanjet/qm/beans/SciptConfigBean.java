package com.chanjet.qm.beans;

import java.io.Serializable;

public class SciptConfigBean implements Serializable {
    private static final long serialVersionUID = -2682305557890221059L;

    private Long id;

    private int orderNum;

    private String stepName;

    private String stepDesc;

    private String reqParams;

    private String rspParams;

    private String releParams;

    private String templId;

    private String reqInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplId() {
        return templId;
    }

    public void setTemplId(String templId) {
        this.templId = templId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getRspParams() {
        return rspParams;
    }

    public void setRspParams(String rspParams) {
        this.rspParams = rspParams;
    }

    public String getReleParams() {
        return releParams;
    }

    public void setReleParams(String releParams) {
        this.releParams = releParams;
    }

    public String getReqInfo() {
        return reqInfo;
    }

    public void setReqInfo(String reqInfo) {
        this.reqInfo = reqInfo;
    }

}