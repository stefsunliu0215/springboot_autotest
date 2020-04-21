package com.liu.bean;

/**
 * @ClassName: ApproveRecord
 * @Description: 审批流转记录
 * @Author: 52945
 * @Date: 2020/1/8 14:07
 * @Version: 1.0
 */
public class ApproveRecord {

    private String linkName;
    private String approver;
    private String arriveTime;
    private String approveTime;
    private String approveOpinion;
    private String commitPath;

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    public String getCommitPath() {
        return commitPath;
    }

    public void setCommitPath(String commitPath) {
        this.commitPath = commitPath;
    }

}
