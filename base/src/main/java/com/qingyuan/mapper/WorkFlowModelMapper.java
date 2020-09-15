package com.qingyuan.mapper;


import com.qingyuan.pojo.WorkFlowModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 表：workflow_model
 * @author 24605
 */
@Mapper
public interface WorkFlowModelMapper {


    /**
     * 插入模型
     * @param workFlowModel
     * @return
     */
    int insertModel(WorkFlowModel workFlowModel);


    /**
     * 获取所有模型
     * @return
     */
    List<WorkFlowModel> selectAllModel();

    /**
     * 查找所有未处于此状态的模型
     * @param status 状态
     * @return
     */
    List<WorkFlowModel> selectAllUnStatusModel(String status);

    /**
     * 更新模型状态
     * @param workFlowModelIds
     * @param status
     * @return
     */
    int changeModelStatus(List<Integer> workFlowModelIds,String status);
}
