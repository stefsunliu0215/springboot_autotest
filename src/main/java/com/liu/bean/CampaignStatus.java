package com.liu.bean;

/**
 * @ClassName: CampaignStatus
 * @Description: 营销安状态枚举类
 * @Author: 52945
 * @Date: 2019/11/8 10:37
 * @Version: 1.0
 */
public enum CampaignStatus {

    //0：草稿，1：待提交，2：审批中，3：审批通过，4：审批驳回，5：待执行，6：执行中，7：结束
    DRAFT(0, "草稿"),
    TO_SUBMIT(1, "待提交"),
    APPROVING(2, "审批中"),
    APPROVED(3, "审批通过"),
    REJECTED(4, "审批驳回"),
    TO_EXECUTED(5, "待执行"),
    EXECUTING(6, "执行中"),
    FINISH(7, "结束");

    private Integer code;
    private String name;

    CampaignStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据类型的编码，返回类型的枚举实例。
     *
     * @param code 行业类别编码
     */
    public static CampaignStatus getType(Integer code) {
        for (CampaignStatus type : CampaignStatus.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return name;
    }

}
