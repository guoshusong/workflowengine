package com.qingyuan.util.Enum;

/**
 * 审批类型枚举类
 * @author 24605
 */

public enum ApproveTypeEnum {
    APPROVE_SPECIFY_USER_ANY(0,"指定其中一人审批通过"),
    APPROVE_SPECIFY_USER_ALL(1,"指定所有人审批通过"),
    APPROVE_AUTHORITY_ANY(2,"满足权限的其中一人通过即可"),
    APPROVE_AUTHORITY_ALL(3,"满足权限的所有人通过即可");

    /**
     * 审批结果id
     */
    private Integer ApproveTypeId;

    /**
     * 审批结果
     */
    private String ApproveType;

    public Integer getApproveTypeId() {
        return ApproveTypeId;
    }

    public void setApproveTypeId(Integer approveTypeId) {
        ApproveTypeId = approveTypeId;
    }

    public String getApproveType() {
        return ApproveType;
    }

    public void setApproveType(String approveType) {
        ApproveType = approveType;
    }

    ApproveTypeEnum(){

    }

    ApproveTypeEnum(Integer approveTypeId, String approveType) {
        ApproveTypeId = approveTypeId;
        ApproveType = approveType;
    }
}
