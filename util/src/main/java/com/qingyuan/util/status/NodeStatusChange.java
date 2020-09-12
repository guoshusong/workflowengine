package com.qingyuan.util.status;

import com.qingyuan.database.mapper.NodeMapper;
import com.qingyuan.object.DTO.node.Node;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 状态回滚
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-09 20:43
 **/
@Component
public class NodeStatusChange {

    @Resource
    private NodeMapper nodeMapper;

    /**
     * 节点状态回滚
     * @param nodeId 节点id
     * @param nowStatus 现在的状态
     * @param nextStatus 下一状态
     * @return
     */
    public  Node statusChange(Integer nodeId,String nowStatus,String nextStatus){
        Node node = nodeMapper.getNodeByNodeId(nodeId);
        return node;
    }
}
