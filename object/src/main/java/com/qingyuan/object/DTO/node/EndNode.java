package com.qingyuan.object.DTO.node;

import com.qingyuan.util.Enum.StatusEnum;
import lombok.Data;

/**
 * 结束节点
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 10:55
 **/
@Data
public class EndNode extends Node{

    /**
     * 上一节点id
     */
    protected Integer preNodeId;

    /**
     * 起始节点id
     */
    protected Integer startNodeId;

    public EndNode(){

    }

    public EndNode(StartNode startNode,Integer preNodeId){
        this.nodeId = startNode.nodeId;
        this.nodeName = startNode.nodeName;
        this.applyUserId=startNode.applyUserId;
        this.applyTime = startNode.applyTime;
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nodeTypeId -= startNode.nodeTypeId;
        this.startNodeId = startNode.nodeId;
        this.startTime =startNode.startTime;
        this.endTime = startNode.endTime;
        this.preNodeId = preNodeId;
        this.approveAuthorityId = startNode.approveAuthorityId;
        this.approveTypeId = startNode.approveTypeId;
        this.approveUsersId = startNode.approveUsersId;
    }

    public EndNode(TaskNode taskNode){
        this.nodeId = taskNode.nodeId;
        this.nodeName = taskNode.nodeName;
        this.applyUserId=taskNode.applyUserId;
        this.applyTime = taskNode.applyTime;
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nodeTypeId -= taskNode.nodeTypeId;
        this.startNodeId = taskNode.nodeId;
        this.preNodeId = taskNode.preNodeId;
        this.startTime =taskNode.startTime;
        this.endTime = taskNode.endTime;
        this.approveAuthorityId =taskNode.approveAuthorityId;
        this.approveTypeId=taskNode.approveTypeId;
        this.approveUsersId = taskNode.approveUsersId;
    }
}
