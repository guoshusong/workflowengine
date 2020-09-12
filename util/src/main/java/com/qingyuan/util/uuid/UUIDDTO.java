package com.qingyuan.util.uuid;

import lombok.Data;

/**
 * 分布式数据id生成
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-12 10:48
 **/

@Data
public class UUIDDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 目前为止的最大数值
     */
    private Integer maxId;


    /**
     * 步长
     */
    private Integer stepLength;


    /**
     * 乐观锁
     */
    private Integer version;
}
