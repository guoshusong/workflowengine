package com.qingyuan.Enum;

/**
 * 业务类型枚举类
 * @author 24605
 */
public enum BizTypeEnum {
    //节点
    WORK_FLOW_NODE(0,"节点"),
    WORK_FLOW_MODEL(1,"模型"),
    ;

    /**
     * 业务类型id
     */
    private Integer bizType;

    /**
     * 业务类型
     */
    private String bizTypeName;

    BizTypeEnum(Integer bizType, String bizTypeName) {
        this.bizType = bizType;
        this.bizTypeName = bizTypeName;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }

    public void setBizTypeName(String bizTypeName) {
        this.bizTypeName = bizTypeName;
    }
}
