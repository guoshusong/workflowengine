package com.qingyuan.Enum;

/**
 *节点状态枚举类
 * @author 24605
 */
public enum StatusEnum {

    NODE_CREATED(0,"创建"),
    NODE_CANCEL(1,"取消"),
    NODE_FINISHED(2,"通过"),
    NODE_REFUSE(3,"拒绝"),
    NODE_EXPIRED(4,"过期")
    ;


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
