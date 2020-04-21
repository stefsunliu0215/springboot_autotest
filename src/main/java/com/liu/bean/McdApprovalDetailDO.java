package com.liu.bean;

import java.util.Date;

public class McdApprovalDetailDO {
	
	/**
	 * 营销案ID
	 */
	private String campaignId;
	
	/**
	 * 审批流ID
	 */
	private String flowId;
	/**
	 * 节点id
	 */
	private String nodeId;
	/**
	 * 当前环节
	 */
	private String node;
	/**
	 * 审批人
	 */
	private String approveUser;
	/**
	 * 审批结果
	 */
	private String result;
	/**
	 * 审批意见
	 */
	private String advice;
	/**
	 * 提交路径
	 */
	private String submitPath;
	/**
	 * 到达时间
	 */
	private Date createTime;
	/**
	 * 审批时间
	 */
	private Date approveTime;
	/**
	 * 后续处理环节
	 */
	private String nextNodes;
	
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getApproveUser() {
		return approveUser;
	}
	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getSubmitPath() {
		return submitPath;
	}
	public void setSubmitPath(String submitPath) {
		this.submitPath = submitPath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public String getNextNodes() {
		return nextNodes;
	}
	public void setNextNodes(String nextNodes) {
		this.nextNodes = nextNodes;
	}
	
	
}
