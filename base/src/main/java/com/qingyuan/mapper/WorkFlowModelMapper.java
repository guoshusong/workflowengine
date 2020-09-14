package com.qingyuan.mapper;


import com.qingyuan.pojo.WorkFlowModel;
import org.apache.ibatis.annotations.Mapper;

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
}
