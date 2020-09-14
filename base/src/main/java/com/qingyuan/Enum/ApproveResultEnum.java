package com.qingyuan.Enum;

/**
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-07 20:31
 **/
public enum  ApproveResultEnum {
    APPROVE_PASS(0,"通过"),
    APPROVE_REFUSE(1,"拒绝")
    ;

    /**
     * 结果id
     */
    private Integer approveResultId;

    /**
     * 结果
     */
    private String approveResult;

     ApproveResultEnum(){

    }

    ApproveResultEnum(int approveResultId, String approveResult) {
        this.approveResult = approveResult;
        this.approveResultId= approveResultId;
    }

    public Integer getApproveResultId() {
        return approveResultId;
    }

    public void setApproveResultId(Integer approveResultId) {
        this.approveResultId = approveResultId;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }
}
