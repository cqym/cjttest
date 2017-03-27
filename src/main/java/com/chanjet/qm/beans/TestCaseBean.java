package com.chanjet.qm.beans;

import java.io.Serializable;
import java.util.Date;

public class TestCaseBean implements Serializable {
    private static final long serialVersionUID = -2682305557890221059L;

    private Long id;

    private String caseName;

    private Long parentId;

    private String caseDisc;

    private String priority;

    private String caseNo;

    private Date createDate;

    private Date updateDate;

    private Long scriptId;

    private Long userId;

    private boolean leaf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCaseDisc() {
        return caseDisc;
    }

    public void setCaseDisc(String caseDisc) {
        this.caseDisc = caseDisc;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
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

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

}