package com.qingyuan.util.Enum;

/**
 *节点状态枚举类
 * @author 24605
 */
public enum StatusEnum {

    NODE_CREATED(0,"创建"),
    NODE_FINISHED(1,"通过"),
    NODE_EXPIRED(2,"过期"),
    NODE_CANCEL(3,"取消"),
    NODE_REFUSE(4,"拒绝");


    /**
     * 状态id
     */
    private Integer NodeStatusId;

    /**
     * 状态
     */
    private String NodeStatus;

    public Integer getNodeStatusId() {
        return NodeStatusId;
    }

    public void setNodeStatusId(Integer nodeStatusId) {
        NodeStatusId = nodeStatusId;
    }

    public String getNodeStatus() {
        return NodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        NodeStatus = nodeStatus;
    }

    StatusEnum(Integer nodeStatusId, String nodeStatus) {
        NodeStatusId = nodeStatusId;
        NodeStatus = nodeStatus;
    }
}
