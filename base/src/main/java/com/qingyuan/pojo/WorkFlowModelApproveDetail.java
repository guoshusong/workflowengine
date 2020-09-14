package com.qingyuan.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-07 20:09
 **/
@Data
public class WorkFlowModelApproveDetail {

    /**
     * 模型id
     */
    private Integer modelId;

    /**
     * 审批人id
     */
    private Integer approveUserId;

    /***
     * 审批结果
     * 通过
     * 拒绝
     */
    private String approveResult;

    /**
     * 审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String approveTime;

    /**
     * 审批备注
     */
    private String approveDetail;
}
