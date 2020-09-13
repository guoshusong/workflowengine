package com.qingyuan.util.mapper;

import com.qingyuan.util.uuid.UUIDDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 表UUID对应的相关操作
 * @author 24605
 */
@Mapper
public interface UUIDMapper {
    /**
     * 初始化某一业务类型的UUID
     * @param bizType 业务类型
     * @param stepLength 步长
     * @return int
     */
    int intiUUID(Integer bizType, Integer stepLength);

    /**
     * 根据业务类型查找
     * @param bizType
     * @return
     */
    UUIDDTO selectUUID(Integer bizType);

    /**
     * 此处是将maxID加一个步长
     * @param bizType
     * @return
     */
    int plusMaxID(Integer bizType);

    /**
     * 更新数据库
     * @param uuiddto
     * @return
     */
    int updateUUID(UUIDDTO uuiddto);
}
