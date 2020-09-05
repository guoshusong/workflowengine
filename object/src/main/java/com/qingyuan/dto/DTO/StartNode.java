package com.qingyuan.dto.DTO;

import lombok.Data;

/**
 * 开始节点
 * 流程的开始，做一些初始化操作的节点。
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-05 20:06
 **/
@Data
public class StartNode {

    /**
     * 节点id(流程节点的唯一标识)
     */
    private String nodeId;

    /**
     * 节点名称(节点做什么的)
     */
    private String nodeName;

    /**
     * 	下一个节点id
     */
    private String nextNodeId;

    /**
     * 节点所属部门Id
     */
    private Integer nodeDepartmentId;

    
}
