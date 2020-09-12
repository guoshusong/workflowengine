package com.qingyuan.example.POJO;

import com.qingyuan.object.VO.WorkFlowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 面试工作流模型
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-07 19:43
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class InterviewWorkFlowModel  extends WorkFlowModel {

    /**
     * 面试轮次
     * 决定有几个节点
     */
    private Integer interviewRounds;

    /**
     * 面试评价的参数
     * 传递数据时，用英文逗号隔开
     */
    private String paramName;


}
