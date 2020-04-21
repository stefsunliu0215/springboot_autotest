package com.liu.bean;

import java.io.Serializable;
import java.util.Date;

public class McdCampProdDefBO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 营销案id
     */
    private String campaignId;
    /**
     * 营销案名称
     */
    private String campaignName;
    /**
     * 营销案类型
     */
    private Integer campaignType;
    /**
     * 营销案名称
     */
    private String campaignTypeName;

    /**
     * 营销场景类型
     */
    private String campScene;
    /**
     * 营销场景name
     */
    private String campSceneName;
    /**
     * 业务类型
     */
    private Integer serviceType;
    /**
     * 业务类型名称
     */
    private String serviceTypeName;
    /**
     * 营销案优先级
     */
    private Integer campaignPriority;
    /**
     * 营销案状态 0：草稿，1：待提交，2：审批中，3：审批通过，4：审批驳回，5：待执行，6：执行中，7：结束
     */
    private Integer campaignStatus;
    /**
     * 营销案状态名称
     */
    private String campaignStatusName;
    /**
     * 营销案描述
     */
    private String campaignDesc;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 活动状态
     */
    private Integer isVirtual;
    /**
     * 是否剔除已办理 0：否，1：是
     */
    private Integer isExcludeOrdered;
    /**
     * 客户群ID
     */
    private String custGroupId;
    /**
     * 审批流ID
     */
    private String approveFlowId;
    /**
     * 审批结果
     */
    private Integer approveResult;
    /**
     * 创建人ID
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 发起方式
     */
    private String launchMode;
    /**
     * 发起方式名称
     */
    private String launchModeName;
    /**
     * 折扣类型
     */
    private Integer discountType;
    /**
     * 预计发生折扣
     */
    private double expectedDiscount;
    /**
     * 业务维度1 1：存量，2：增量
     */
    private String firstClass;
    /**
     * 业务维度2 1：终端，2：新业务，3：流量，4：宽带，5：集客_校讯通，6：集客_流量，7：集客_统付，8：集客_其他
     */
    private Integer secondClass;
    /**
     * 业务维度2名称
     */
    private String secondClassName;
    /**
     * 活动背景/促销方案
     */
    private String campaignBackground;
    /**
     * 业务规则/宣传方案
     */
    private String campaignRule;
    /**
     * 预期目标
     */
    private String expectedTarget;
    /**
     * 资源投入
     */
    private String resourceInput;
    /**
     * 经济性测算
     */
    private String economicEstimation;
    /**
     * 风险管控
     */
    private String riskManagement;
    /**
     * boss附件回传大小
     */
    private String attachmentBossSize;
    /**
     * boss附件回传时间
     */
    private String attachmentBossTime;
    /**
     * 地市ID
     */
    private String cityId;
    /**
     * 接触次数
     */
    private Integer contactTimes;
    /**
     * 接触间隔
     */
    private Integer contactInterval;
    /**
     * 营销案办理成功提示语
     */
    private String handlingSuccessTips;
    /**
     * 是否发送短信
     */
    private String isSendSms;
    /**
     * 上传附件路径
     */
    private String attachmentBoss;

    /**
     * 创建人名称
     */
    private String userName;

    /**
     * 状态名称
     */
    private String statusValue;

    /**
     * 营销案类型名称
     */
    private String typeValue;

    private Date approveTime;
    /**
     * 客户群名称
     */
    private String customGroupName;

    /**
     * 产品简介与竞品分析
     */
    private String analysisPlanProduct;

    /**
     * 价格及优惠与促销内容
     */
    private String favorablePrice;

    /**
     * 渠道承载及对应酬金/量酬
     */
    private String channelAndReward;

    /**
     * 是否广告及宣传推广方式
     */
    private String advertisingAndPromotion;

    /**
     * 客户服务与解答口径
     */
    private String custService;

    /**
     * 2+1+N服务要素核查
     */
    private String neleVerification;

    /**
     * 效益分析
     */
    private String benefitAnalysis;

    /**
     * 活动开展范围
     */
    private String marketingPlanCity;
    /**
     * 活动开展范围名称
     */
    private String marketingPlanCityName;

    /**
     * 客户服务与解答口径文件大小
     */
    private String custServiceSize;

    /**
     * 2+1+N服务要素核查文件大小
     */
    private String neleVerificationSize;

    /**
     * 效益分析文件大小
     */
    private String benefitAnalysisSize;


    /**
     * 客户服务与解答口径文件上传时间
     */
    private String custServiceTime;


    /**
     * 2+1+N服务要素核查文件上传时间
     */
    private String neleVerificationTime;

    /**
     * 效益分析文件上传时间
     */
    private String benefitAnalysisTime;

    /**
     * 执行中的上传的测试报告
     */
    private String doUploadTestFile;

    /**
     * 完成的上传的后评估报告
     */
    private String finishUploadEvaluateFile;


    /**
     * 资源投入的折扣折让描述
     */
    private String resourceInputDesc1;

    /**
     * 资源投入的实体卡描述
     */
    private String resourceInputDesc2;

    /**
     * 资源投入的酬金描述
     */
    private String resourceInputDesc3;

    /**
     * 资源投入的其他描述
     */
    private String resourceInputDesc4;


    /**
     * 其它附件
     */
    private String attachment;

    /**
     * 其它附件文件大小
     */
    private String attachmentSize;

    /**
     * 其它附件文件上传时间
     */
    private String attachmentTime;


    /**
     * bossId
     */
    private String bossId;


    /**
     * 待审批结束时间
     */
    private Date endTimeUnapprove;

    /**
     * 待审批客户群ID
     */
    private String custGroupUnapprove;

    /**
     * BOSS状态  1：配置中，2：返回附件
     */
    private Integer bossStatus;
    /**
     * 是否修改客户群  0：否，1：是
     */
    private Integer isModifyGroupId;

    /**
     * 是否修改时间  0：否，1：是
     */
    private Integer isModifyTime;

    /**
     * 是否是U文件详情页面：0：否；1:是
     */
    private String isUBossAttach;
    /**
     * 所属市场
     */
    private String ownMarket;
    /**
     * 所属市场名称
     */
    private String ownMarketName;
    /**
     * 主推业务
     */
    private String mainBusiness;
    /**
     * 主推业务名称
     */
    private String mainBusinessName;
    /**
     * 营销专题
     */
    private Integer mainTopic;
    /**
     * 营销专题名称
     */
    private String mainTopicName;
    /**
     * 营销业务类型
     */
    private Integer businessType;
    /**
     * 营销业务类型名称
     */
    private String businessTypeName;

	public String getOwnMarket() {
		return ownMarket;
	}

	public void setOwnMarket(String ownMarket) {
		this.ownMarket = ownMarket;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public Integer getMainTopic() {
		return mainTopic;
	}

	public void setMainTopic(Integer mainTopic) {
		this.mainTopic = mainTopic;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsUBossAttach() {
        return isUBossAttach;
    }

    public void setIsUBossAttach(String isUBossAttach) {
        this.isUBossAttach = isUBossAttach;
    }

    public Date getEndTimeUnapprove() {
        return endTimeUnapprove;
    }

    public void setEndTimeUnapprove(Date endTimeUnapprove) {
        this.endTimeUnapprove = endTimeUnapprove;
    }

    public String getCustGroupUnapprove() {
        return custGroupUnapprove;
    }

    public void setCustGroupUnapprove(String custGroupUnapprove) {
        this.custGroupUnapprove = custGroupUnapprove;
    }

    public Integer getBossStatus() {
        return bossStatus;
    }

    public void setBossStatus(Integer bossStatus) {
        this.bossStatus = bossStatus;
    }

    public Integer getIsModifyGroupId() {
        return isModifyGroupId;
    }

    public void setIsModifyGroupId(Integer isModifyGroupId) {
        this.isModifyGroupId = isModifyGroupId;
    }

    public Integer getIsModifyTime() {
        return isModifyTime;
    }

    public void setIsModifyTime(Integer isModifyTime) {
        this.isModifyTime = isModifyTime;
    }

    public String getMarketingPlanCityName() {
        return marketingPlanCityName;
    }

    public void setMarketingPlanCityName(String marketingPlanCityName) {
        this.marketingPlanCityName = marketingPlanCityName;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Integer getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(Integer campaignType) {
        this.campaignType = campaignType;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getCampaignPriority() {
        return campaignPriority;
    }

    public void setCampaignPriority(Integer campaignPriority) {
        this.campaignPriority = campaignPriority;
    }

    public Integer getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(Integer campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public String getCampaignDesc() {
        return campaignDesc;
    }

    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Integer getIsExcludeOrdered() {
        return isExcludeOrdered;
    }

    public void setIsExcludeOrdered(Integer isExcludeOrdered) {
        this.isExcludeOrdered = isExcludeOrdered;
    }

    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
    }

    public String getApproveFlowId() {
        return approveFlowId;
    }

    public void setApproveFlowId(String approveFlowId) {
        this.approveFlowId = approveFlowId;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLaunchMode() {
        return launchMode;
    }

    public void setLaunchMode(String launchMode) {
        this.launchMode = launchMode;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public double getExpectedDiscount() {
        return expectedDiscount;
    }

    public void setExpectedDiscount(double expectedDiscount) {
        this.expectedDiscount = expectedDiscount;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public Integer getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(Integer secondClass) {
        this.secondClass = secondClass;
    }

    public String getCampaignBackground() {
        return campaignBackground;
    }

    public void setCampaignBackground(String campaignBackground) {
        this.campaignBackground = campaignBackground;
    }

    public String getCampaignRule() {
        return campaignRule;
    }

    public void setCampaignRule(String campaignRule) {
        this.campaignRule = campaignRule;
    }

    public String getExpectedTarget() {
        return expectedTarget;
    }

    public void setExpectedTarget(String expectedTarget) {
        this.expectedTarget = expectedTarget;
    }

    public String getResourceInput() {
        return resourceInput;
    }

    public void setResourceInput(String resourceInput) {
        this.resourceInput = resourceInput;
    }

    public String getEconomicEstimation() {
        return economicEstimation;
    }

    public void setEconomicEstimation(String economicEstimation) {
        this.economicEstimation = economicEstimation;
    }

    public String getRiskManagement() {
        return riskManagement;
    }

    public void setRiskManagement(String riskManagement) {
        this.riskManagement = riskManagement;
    }

    public String getAttachmentBossSize() {
        return attachmentBossSize;
    }

    public void setAttachmentBossSize(String attachmentBossSize) {
        this.attachmentBossSize = attachmentBossSize;
    }

    public String getAttachmentBossTime() {
        return attachmentBossTime;
    }

    public void setAttachmentBossTime(String attachmentBossTime) {
        this.attachmentBossTime = attachmentBossTime;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getContactTimes() {
        return contactTimes;
    }

    public void setContactTimes(Integer contactTimes) {
        this.contactTimes = contactTimes;
    }

    public Integer getContactInterval() {
        return contactInterval;
    }

    public void setContactInterval(Integer contactInterval) {
        this.contactInterval = contactInterval;
    }

    public String getHandlingSuccessTips() {
        return handlingSuccessTips;
    }

    public void setHandlingSuccessTips(String handlingSuccessTips) {
        this.handlingSuccessTips = handlingSuccessTips;
    }

    public String getIsSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(String isSendSms) {
        this.isSendSms = isSendSms;
    }

    public String getCampaignTypeName() {
        return campaignTypeName;
    }

    public void setCampaignTypeName(String campaignTypeName) {
        this.campaignTypeName = campaignTypeName;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public String getCampaignStatusName() {
        return campaignStatusName;
    }

    public void setCampaignStatusName(String campaignStatusName) {
        this.campaignStatusName = campaignStatusName;
    }

    public String getSecondClassName() {
        return secondClassName;
    }

    public void setSecondClassName(String secondClassName) {
        this.secondClassName = secondClassName;
    }

    public String getAttachmentBoss() {
        return attachmentBoss;
    }

    public void setAttachmentBoss(String attachmentBoss) {
        this.attachmentBoss = attachmentBoss;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getLaunchModeName() {
        return launchModeName;
    }

    public void setLaunchModeName(String launchModeName) {
        this.launchModeName = launchModeName;
    }

    public String getCustomGroupName() {
        return customGroupName;
    }

    public void setCustomGroupName(String customGroupName) {
        this.customGroupName = customGroupName;
    }

    public String getBossId() {
        return bossId;
    }

    public void setBossId(String bossId) {
        this.bossId = bossId;
    }


    public String getAnalysisPlanProduct() {
        return analysisPlanProduct;
    }

    public void setAnalysisPlanProduct(String analysisPlanProduct) {
        this.analysisPlanProduct = analysisPlanProduct;
    }

    public String getFavorablePrice() {
        return favorablePrice;
    }

    public void setFavorablePrice(String favorablePrice) {
        this.favorablePrice = favorablePrice;
    }

    public String getChannelAndReward() {
        return channelAndReward;
    }

    public void setChannelAndReward(String channelAndReward) {
        this.channelAndReward = channelAndReward;
    }

    public String getAdvertisingAndPromotion() {
        return advertisingAndPromotion;
    }

    public void setAdvertisingAndPromotion(String advertisingAndPromotion) {
        this.advertisingAndPromotion = advertisingAndPromotion;
    }

    public String getCustService() {
        return custService;
    }

    public void setCustService(String custService) {
        this.custService = custService;
    }

    public String getNeleVerification() {
        return neleVerification;
    }

    public void setNeleVerification(String neleVerification) {
        this.neleVerification = neleVerification;
    }

    public String getBenefitAnalysis() {
        return benefitAnalysis;
    }

    public void setBenefitAnalysis(String benefitAnalysis) {
        this.benefitAnalysis = benefitAnalysis;
    }

    public String getMarketingPlanCity() {
        return marketingPlanCity;
    }

    public void setMarketingPlanCity(String marketingPlanCity) {
        this.marketingPlanCity = marketingPlanCity;
    }


    public String getCustServiceSize() {
        return custServiceSize;
    }

    public void setCustServiceSize(String custServiceSize) {
        this.custServiceSize = custServiceSize;
    }

    public String getNeleVerificationSize() {
        return neleVerificationSize;
    }

    public void setNeleVerificationSize(String neleVerificationSize) {
        this.neleVerificationSize = neleVerificationSize;
    }

    public String getBenefitAnalysisSize() {
        return benefitAnalysisSize;
    }

    public void setBenefitAnalysisSize(String benefitAnalysisSize) {
        this.benefitAnalysisSize = benefitAnalysisSize;
    }


    public String getCustServiceTime() {
        return custServiceTime;
    }

    public void setCustServiceTime(String custServiceTime) {
        this.custServiceTime = custServiceTime;
    }

    public String getNeleVerificationTime() {
        return neleVerificationTime;
    }

    public void setNeleVerificationTime(String neleVerificationTime) {
        this.neleVerificationTime = neleVerificationTime;
    }

    public String getBenefitAnalysisTime() {
        return benefitAnalysisTime;
    }

    public void setBenefitAnalysisTime(String benefitAnalysisTime) {
        this.benefitAnalysisTime = benefitAnalysisTime;
    }

    public String getDoUploadTestFile() {
        return doUploadTestFile;
    }

    public void setDoUploadTestFile(String doUploadTestFile) {
        this.doUploadTestFile = doUploadTestFile;
    }

    public String getFinishUploadEvaluateFile() {
        return finishUploadEvaluateFile;
    }

    public void setFinishUploadEvaluateFile(String finishUploadEvaluateFile) {
        this.finishUploadEvaluateFile = finishUploadEvaluateFile;
    }

    public String getResourceInputDesc1() {
        return resourceInputDesc1;
    }

    public void setResourceInputDesc1(String resourceInputDesc1) {
        this.resourceInputDesc1 = resourceInputDesc1;
    }

    public String getResourceInputDesc2() {
        return resourceInputDesc2;
    }

    public void setResourceInputDesc2(String resourceInputDesc2) {
        this.resourceInputDesc2 = resourceInputDesc2;
    }

    public String getResourceInputDesc3() {
        return resourceInputDesc3;
    }

    public void setResourceInputDesc3(String resourceInputDesc3) {
        this.resourceInputDesc3 = resourceInputDesc3;
    }

    public String getResourceInputDesc4() {
        return resourceInputDesc4;
    }

    public void setResourceInputDesc4(String resourceInputDesc4) {
        this.resourceInputDesc4 = resourceInputDesc4;
    }


    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    public String getAttachmentTime() {
        return attachmentTime;
    }

    public void setAttachmentTime(String attachmentTime) {
        this.attachmentTime = attachmentTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCampScene() {
        return campScene;
    }

    public void setCampScene(String campScene) {
        this.campScene = campScene;
    }

    public String getCampSceneName() {
        return campSceneName;
    }

    public void setCampSceneName(String campSceneName) {
        this.campSceneName = campSceneName;
    }

	public String getOwnMarketName() {
		return ownMarketName;
	}

	public void setOwnMarketName(String ownMarketName) {
		this.ownMarketName = ownMarketName;
	}

	public String getMainBusinessName() {
		return mainBusinessName;
	}

	public void setMainBusinessName(String mainBusinessName) {
		this.mainBusinessName = mainBusinessName;
	}

	public String getMainTopicName() {
		return mainTopicName;
	}

	public void setMainTopicName(String mainTopicName) {
		this.mainTopicName = mainTopicName;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}
    
}
