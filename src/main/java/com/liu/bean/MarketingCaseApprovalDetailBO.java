package com.liu.bean;

import java.io.Serializable;
import java.util.List;

public class MarketingCaseApprovalDetailBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 审批流程名称
	 */
	private String flowTitle;
	/**
	 * 审批流程描述
	 */
	private String flowDesc;
	/**
	 * 审批流程
	 */
	private List<McdApprovalDetailDO> detailDO;
	public String getFlowTitle() {
		return flowTitle;
	}
	public void setFlowTitle(String flowTitle) {
		this.flowTitle = flowTitle;
	}
	public String getFlowDesc() {
		return flowDesc;
	}
	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}
	public List<McdApprovalDetailDO> getDetailDO() {
		return detailDO;
	}
	public void setDetailDO(List<McdApprovalDetailDO> detailDO) {
		this.detailDO = detailDO;
	}
	
	

}
