package com.qingyuan.pojo;

import com.qingyuan.pojo.Node;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;
/**
 * 流程模型
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-06 16:11
 **/
@Data
public class WorkFlowModel implements Serializable{

    private static final long serialVersionUID = -3978388377128544781L;

    /**
     * 流程模型id
     */
    protected Integer modelId;
    /**
     * 流程模型名称
     */
    protected String modelName;
    /**
     * 流程模型节点集合
     * 此内容不应存在数据库中
     */
    protected List<Node> nodeList;

    /**
     * 流程模型状态
     */
    protected String modelStatus;

    /**
     * 所属部门id
     */
    protected Integer departmentId;

    /**
     * 流程模型申请人
     */
    protected Integer applyUserId;

    /**
     * 流程模型申请时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected String applyTime;

    /**
     * 起始节点id
     */
    protected Integer startNodeId;

    /**
     * 结束节点id
     */
    protected Integer endNodeId;

    /**
     * 起始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected String startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected String endTime;

    /**
     * 审批类型
     * 0 any
     * 1 all
     */
    protected Integer approveTypeId;

    /**
     * 审批人权限id
     */
    protected Integer approveAuthorityId;

    public WorkFlowModel() {
    }



    public WorkFlowModel(Integer modelId, String modelName, String modelStatus, Integer departmentId, Integer applyUserId,
                         String applyTime, String startTime, String endTime, Integer approveTypeId, Integer approveAuthorityId,
                         String approveUsersId) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelStatus = modelStatus;
        this.departmentId = departmentId;
        this.applyUserId = applyUserId;
        this.applyTime = applyTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.approveTypeId = approveTypeId;
        this.approveAuthorityId = approveAuthorityId;
        this.approveUsersId = approveUsersId;
    }

    public WorkFlowModel(Integer modelId, String modelName, List<Node> nodeList, String modelStatus, Integer departmentId,
                         Integer applyUserId, String applyTime, Integer startNodeId, Integer endNodeId, String startTime,
                         String endTime, Integer approveTypeId, Integer approveAuthorityId, String approveUsersId) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.nodeList = nodeList;
        this.modelStatus = modelStatus;
        this.departmentId = departmentId;
        this.applyUserId = applyUserId;
        this.applyTime = applyTime;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.approveTypeId = approveTypeId;
        this.approveAuthorityId = approveAuthorityId;
        this.approveUsersId = approveUsersId;
    }

    /**
     * 审批人id
     * 传递参数时请用[,,]这种方式传递
     */
    protected String approveUsersId;

    /**
     * 在指定位置插入节点(注意位置起始从1开始)
     * @param position
     * @param node
     */
    public boolean addNode(Integer position, Node node){
        try{
            nodeList.add(position-1,node);
            if (position.equals(nodeList.size())){
                endNodeId = node.getNodeId();
            }
            if (position == 1){
                startNodeId = node.getNodeId();
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 在最后插入节点
     * @param node
     * @return
     */
    public boolean addNodeLast(Node node){
        try{
            nodeList.add(node);
            endNodeId = node.getNodeId();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


