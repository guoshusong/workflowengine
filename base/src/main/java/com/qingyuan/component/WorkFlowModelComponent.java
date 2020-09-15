package com.qingyuan.component;

import com.qingyuan.Enum.BizTypeEnum;
import com.qingyuan.Enum.NodeTypeEnum;
import com.qingyuan.Enum.StatusEnum;
import com.qingyuan.mapper.NodeMapper;
import com.qingyuan.mapper.WorkFlowModelMapper;
import com.qingyuan.pojo.Node;
import com.qingyuan.pojo.WorkFlowModel;
import com.qingyuan.util.ListToHashMap;
import com.qingyuan.util.uuid.UUIDGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 构建工程流模型
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-14 20:40
 **/
@Component
public class WorkFlowModelComponent {

    @Resource
    private WorkFlowModelMapper workFlowModelMapper;
    @Resource
    private UUIDGenerator uuidGenerator;
    @Resource
    private NodeMapper nodeMapper;
    @Resource
    private ListToHashMap listToHashMap;

    private  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 初始化一个流程模型
     * @return
     */
    public WorkFlowModel initWorkFlowModel(String modelName,Integer departmentId,Integer applyUserId,String applyTime,
                                           String startTime,String endTime,Integer approveTypeId,Integer approveAuthorityId,
                                           String approveUsersId){
        //生成唯一id
        Integer modelId = uuidGenerator.generateUUID(BizTypeEnum.WORK_FLOW_MODEL.getBizType());
        //获取当前时间
        Date date = new Date();
        WorkFlowModel workFlowModel = new WorkFlowModel(modelId,modelName, StatusEnum.NODE_CREATED.getNodeStatus(),departmentId,applyUserId,
                sdf.format(date).toString(),startTime,endTime,approveTypeId,approveAuthorityId,approveUsersId);
        workFlowModelMapper.insertModel(workFlowModel);
        return workFlowModel;
    }

    /**
     * 获取流程模型的节点(顺序排布)
     * @param workFlowModel
     * @return
     */
    public List<Node> getModelSortedNode(WorkFlowModel workFlowModel){
        List<Node> nodeList = nodeMapper.selectNodeByModelId(workFlowModel.getModelId());
        List<Node> resultList =new LinkedList<>();
        if (nodeList ==  null){
            return null;
        }
        if (nodeList.size() == 1){
            return nodeList;
        }
        //如果没有起始节点
        if (workFlowModel.getStartNodeId()!= null){
            Map<Object, Object> nodeMap = listToHashMap.listToHashMap("nodeId","Node",true,nodeList);
            //包含起始节点id
            if (nodeMap.containsKey(workFlowModel.getStartNodeId())){
                Node node = (Node) nodeMap.get(workFlowModel.getStartNodeId());
                resultList.add(node);
                node = (Node) nodeMap.get(node.getNextNodeId());
                //如果不是结束节点
                while(!node.getNodeTypeId().equals(NodeTypeEnum.TASK_NODE.getNodeTypeId())){
                    resultList.add(node);
                    node = (Node) nodeMap.get(node.getNextNodeId());
                }
                resultList.add(node);
            }
        }
        return resultList;
    }

    /**
     * 检查模型是否过期
     * 每59分钟执行一次
     */
    @Scheduled(cron = "* 0/59 * * * ? *")
    public void checkModelsEffective(){
        //获取所有节点
        List<WorkFlowModel> workFlowModels = workFlowModelMapper.selectAllModel();
        List<Integer> unEffectiveModels = new LinkedList<>();
        for (WorkFlowModel workFlowModel:
             workFlowModels) {
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try{
                Date date = fmt.parse(workFlowModel.getEndTime());
                //当前实践
                Date nowDate = new Date();
                //如果现在的时间在结束时间之后
                if (nowDate.after(date)){
                    unEffectiveModels.add(workFlowModel.getModelId());
                }
            }catch (ParseException ignored){

            }
        }
        workFlowModelMapper.changeModelStatus(unEffectiveModels,StatusEnum.NODE_EXPIRED.getNodeStatus());
    }
}
