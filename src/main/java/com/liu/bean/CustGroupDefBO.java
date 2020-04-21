package com.liu.bean;

import java.io.Serializable;
import java.util.Date;

public class CustGroupDefBO implements Serializable {
    private static final long serialVersionUID = -5501609561796038404L;
    private String customGroupId;
    private String customGroupName;
    private String customGroupDesc;
    private int customNum;
    private int actualCustomNum;
    private int customStatusId;
    private String customStatusName;
    private String customSourceId;
    private String createUserId;
    private String pushTargetUser;
    private Date createTime;
    private Date effectiveTime;
    private Date failTime;
    private int updateCycle;
    private String updateCycleName;
    private String listTableName;
    private String dataDate;
    private String ruleDesc;

    public CustGroupDefBO() {
    }

    public static long getSerialVersionUID() {
        return -5501609561796038404L;
    }

    public String getCustomGroupId() {
        return this.customGroupId;
    }

    public void setCustomGroupId(String customGroupId) {
        this.customGroupId = customGroupId;
    }

    public String getCustomGroupName() {
        return this.customGroupName;
    }

    public void setCustomGroupName(String customGroupName) {
        this.customGroupName = customGroupName;
    }

    public String getCustomGroupDesc() {
        return this.customGroupDesc;
    }

    public void setCustomGroupDesc(String customGroupDesc) {
        this.customGroupDesc = customGroupDesc;
    }

    public int getCustomNum() {
        return this.customNum;
    }

    public void setCustomNum(int customNum) {
        this.customNum = customNum;
    }

    public int getActualCustomNum() {
        return this.actualCustomNum;
    }

    public void setActualCustomNum(int actualCustomNum) {
        this.actualCustomNum = actualCustomNum;
    }

    public int getCustomStatusId() {
        return this.customStatusId;
    }

    public void setCustomStatusId(int customStatusId) {
        this.customStatusId = customStatusId;
    }

    public String getCustomStatusName() {
        return this.customStatusName;
    }

    public void setCustomStatusName(String customStatusName) {
        this.customStatusName = customStatusName;
    }

    public String getCustomSourceId() {
        return this.customSourceId;
    }

    public void setCustomSourceId(String customSourceId) {
        this.customSourceId = customSourceId;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getPushTargetUser() {
        return this.pushTargetUser;
    }

    public void setPushTargetUser(String pushTargetUser) {
        this.pushTargetUser = pushTargetUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEffectiveTime() {
        return this.effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getFailTime() {
        return this.failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    public int getUpdateCycle() {
        return this.updateCycle;
    }

    public void setUpdateCycle(int updateCycle) {
        this.updateCycle = updateCycle;
    }

    public String getUpdateCycleName() {
        return this.updateCycleName;
    }

    public void setUpdateCycleName(String updateCycleName) {
        this.updateCycleName = updateCycleName;
    }

    public String getListTableName() {
        return this.listTableName;
    }

    public void setListTableName(String listTableName) {
        this.listTableName = listTableName;
    }

    public String getDataDate() {
        return this.dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getRuleDesc() {
        return this.ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }
}
