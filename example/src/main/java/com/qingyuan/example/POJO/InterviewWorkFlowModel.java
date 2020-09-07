package com.qingyuan.example.POJO;

import com.qingyuan.object.VO.WorkFlowModel;
import lombok.Data;

/**
 * 面试工作流模型
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-07 19:43
 **/
@Data
public class InterviewWorkFlowModel  extends WorkFlowModel {

    /**
     * 面试轮次
     */
    private Integer interviewRounds;


}
