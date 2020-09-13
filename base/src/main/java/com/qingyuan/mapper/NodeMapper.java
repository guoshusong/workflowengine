package com.qingyuan.mapper;


import com.qingyuan.object.DTO.Node;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库节点相关Mapper
 * @author GuoShuSong
 */
@Mapper
public interface NodeMapper {

    /**
     * 通过节点id获取节点数据
     * @param nodeId 节点id
     * @return Node
     */
    Node getNodeByNodeId(Integer nodeId);


    int InsertNode(Node node);
}
