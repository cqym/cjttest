package com.chanjet.qm.beans;

import java.io.Serializable;
import java.util.Date;

public class TestTaskBean implements Serializable {
    private static final long serialVersionUID = -2682305557890221059L;

    private Long id;

    private String taskName;

    private String taskNo;

    private Long parentId;

    private boolean leaf;

    private String taskDisc;

    private Long userId;

    private Date createDate;

    private Date updateDate;

    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getTaskDisc() {
        return taskDisc;
    }

    public void setTaskDisc(String taskDisc) {
        this.taskDisc = taskDisc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}