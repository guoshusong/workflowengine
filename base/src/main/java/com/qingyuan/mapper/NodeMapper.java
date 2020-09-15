package com.qingyuan.mapper;


import com.qingyuan.pojo.Node;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    Node selectByPrimaryKey(Integer nodeId);

    /**
     * 插入节点
     * @param node
     * @return
     */
    int insert(Node node);

    /**
     * 删除节点
     * @param nodeId
     * @return
     */
    int deleteByPrimaryKey(Integer nodeId);

    /**
     * 插入节点(非空)
     * @param record
     * @return
     */
    int insertSelective(Node record);

    /**
     * 更新节点(非空)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Node record);

    /**
     * 更新节点
     * @param record
     * @return
     */
    int updateByPrimaryKey(Node record);


    /**
     * 根据模型id查询数据
     * @param modelId
     * @return
     */
    List<Node> selectNodeByModelId(Integer modelId);
}
