package com.qingyuan.object.PO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 节点审批类
 * 对应数据库中node_approve_detail表
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 15:58
 **/
@Data
public class NodeApproveDetail {

    /**
     * 节点id
     */
    private Integer nodeId;

    /**
     * 节点审批人id
     */
    private Integer approveUserId;

    /***
     * 审批结果
     * 通过
     * 拒绝
     */
    private String approveResult;

    /**
     * 节点审批备注
     */
    private String approveDetail;

    /**
     * 节点审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String approveTime;
}
