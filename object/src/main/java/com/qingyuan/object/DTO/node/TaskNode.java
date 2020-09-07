package com.qingyuan.object.DTO.node;

import com.qingyuan.util.Enum.StatusEnum;
import lombok.Data;

/**
 * 任务类型节点id
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 10:41
 **/
@Data
public class TaskNode  extends Node {
    /**
     * 下一节点id
     */
    protected Integer nextNodeId;

    /**
     * 上一节点id
     */
    protected Integer preNodeId;

    /**
     * 起始节点id
     */
    protected Integer startNodeId;


    /**
     * 结束节点id
     */
    protected Integer endNodeId;

    public TaskNode(){

    }

    public TaskNode(StartNode startNode, Integer preNodeId, Integer startNodeId) {
        this.nodeId = startNode.nodeId;
        this.nodeName = startNode.nodeName;
        this.applyUserId=startNode.applyUserId;
        this.applyTime = startNode.applyTime;
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nextNodeId = startNode.nextNodeId;
        this.nodeTypeId -= startNode.nodeTypeId;
        this.endNodeId = startNode.endNodeId;
        this.preNodeId = preNodeId;
        this.startNodeId = startNodeId;
        this.startTime =startNode.startTime;
        this.endTime = startNode.endTime;
        this.approveAuthorityId = startNode.approveAuthorityId;
        this.approveUsersId = startNode.approveUsersId;
    }

    public TaskNode(EndNode endNode, Integer nextNodeId){
        this.nodeId = endNode.nodeId;
        this.nodeName = endNode.nodeName;
        this.applyUserId=endNode.applyUserId;
        this.applyTime = endNode.applyTime;
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nodeTypeId -= endNode.nodeTypeId;
        this.preNodeId = endNode.preNodeId;
        this.startNodeId = endNode.startNodeId;
        this.endNodeId = endNode.nodeId;
        this.nextNodeId = nextNodeId;
        this.startTime =endNode.startTime;
        this.endTime = endNode.endTime;
        this.approveAuthorityId = endNode.approveAuthorityId;
        this.approveUsersId = endNode.approveUsersId;
    }
}
