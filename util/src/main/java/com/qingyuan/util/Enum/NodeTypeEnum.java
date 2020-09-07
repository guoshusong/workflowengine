package com.qingyuan.util.Enum;

/**
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 10:31
 **/
public enum  NodeTypeEnum {

    START_NODE(0,"开始节点"),
    TASK_NODE(1,"任务节点"),
    END_NODE(2,"结束节点");

    /**
     * 节点类型Id
     */
    private Integer nodeTypeId;

    /**
     * 节点类型
     */
    private String nodeType;

    public Integer getNodeTypeId() {
        return nodeTypeId;
    }

    public void setNodeTypeId(Integer nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    NodeTypeEnum(Integer nodeTypeId, String nodeType) {
        this.nodeTypeId = nodeTypeId;
        this.nodeType = nodeType;
    }
}
