package com.qingyuan.object.DTO.node;

import lombok.Data;

/**
 * 节点类父类
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 10:19
 **/
@Data
public class Node {
    /**
     * 节点id
     */
    protected Integer nodeId;

    /**
     * 节点名称(描述节点作用)
     */
    protected String nodeName;

    /**
     * 节点类型
     * 0 start
     * 1 task
     * 2 end
     */
    protected Integer nodeTypeId;

    /**
     * 节点申请人
     */
    protected Integer applyUserId;

    /**
     * 节点申请时间
     */
    protected String applyTime;

    /**
     * 节点状态
     */
    protected String nodeStatus;

    /**
     * 节点开始时间
     */
    protected String startTime;
    /**
     * 节点结束时间
     */
    protected String endTime;

    /**
     * 审批人权限id
     */
    protected Integer approveAuthorityId;

    /**
     * 审批人usersId
     */
    protected Integer[] approveUsersId;

    /**
     * 审批类型id
     * 0 any
     * 1 all
     */
    protected Integer approveTypeId;

    public Node(){

    }
}

