package com.qingyuan.object.DTO.node;

import com.qingyuan.util.Enum.StatusEnum;
import lombok.Data;

/**
 * 开始节点
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 10:38
 **/
@Data
public class StartNode extends Node {

    /**
     * 下一节点id
     */
    protected Integer nextNodeId;

    /**
     * 结束节点id
     */
    protected Integer endNodeId;

    public StartNode(){

    }

    /**
     * 将任务节点转换为开始节点
     * @param taskNode
     * @param nextNodeId
     */
    public StartNode(TaskNode taskNode, Integer nextNodeId) {
        this.nodeId = taskNode.nodeId;
        this.nodeName = taskNode.nodeName;
        this.applyUserId=taskNode.applyUserId;
        this.applyTime = taskNode.applyTime;
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nodeTypeId -= taskNode.nodeTypeId;
        this.endNodeId = taskNode.endNodeId;
        this.nextNodeId = nextNodeId;
        this.approveAuthorityId = taskNode.approveAuthorityId;
        this.startTime =taskNode.startTime;
        this.endTime = taskNode.endTime;
        this.approveTypeId = taskNode.approveTypeId;
        this.approveUsersId = taskNode.approveUsersId;
    }

    public StartNode(EndNode endNode,Integer nextNodeId,Integer[] approveUsersId){
        this.nodeStatus = StatusEnum.NODE_CREATED.getNodeStatus();
        this.nodeId = endNode.nodeId;
        this.nodeName = endNode.nodeName;
        this.applyUserId=endNode.applyUserId;
        this.applyTime = endNode.applyTime;
        this.nodeStatus = endNode.nodeStatus;
        this.nodeTypeId -= endNode.nodeTypeId;
        this.endNodeId = endNode.nodeId;
        this.nextNodeId = nextNodeId;
        this.approveAuthorityId = endNode.approveAuthorityId;
        this.startTime =endNode.startTime;
        this.endTime = endNode.endTime;
        this.approveTypeId = endNode.approveTypeId;
        this.approveUsersId = endNode.approveUsersId;
    }
}
