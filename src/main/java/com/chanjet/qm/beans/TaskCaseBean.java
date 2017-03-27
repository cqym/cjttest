package com.chanjet.qm.beans;

import java.io.Serializable;

public class TaskCaseBean implements Serializable {
    private static final long serialVersionUID = -2682305557890221059L;

    private Long id;
    private Long casId;
    private Long taskId;
    private boolean status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCasId() {
        return casId;
    }
    public void setCasId(Long casId) {
        this.casId = casId;
    }
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}