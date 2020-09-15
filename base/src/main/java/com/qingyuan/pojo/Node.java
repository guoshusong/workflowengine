package com.qingyuan.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Integer nodeId;



    /**
     * 节点名称(描述节点作用)
     */
    private String nodeName;

    /**
     * 节点类型
     * 0 start
     * 1 task
     * 2 end
     */
    private Integer nodeTypeId;

    /**
     * 所属模型id
     */
    private Integer modelId;


    /**
     * 节点申请人
     */
    private Integer applyUserId;

    /**
     * 节点申请时间
     */
    private String applyTime;

    /**
     * 节点状态
     */
    private String nodeStatus;

    /**
     * 节点开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    /**
     * 节点结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;


    /**
     * 审批人权限id
     * 审批人权限id与审批人usersId选填一个
     */
    private Integer approveAuthorityId;

    /**
     * 审批人usersId
     * 字符串类型，使用时应该转换为int数组类型
     */
    private String approveUsersId;

    /**
     * 审批类型id
     * 0 any
     * 1 all
     */
    private Integer approveTypeId;

    /**
     * 下一节点id
     */
    private Integer nextNodeId;

    /**
     * 上一节点id
     */
    private Integer preNodeId;

    /**
     * 起始节点id
     */
    private Integer startNodeId;

    /**
     * 结束节点id
     */
    private Integer endNodeId;

    public Node(){

    }
}