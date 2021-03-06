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
     * 初始化过程中如果未指定stepLength则默认为100
     */
    private Integer stepLength;


    /**
     * 乐观锁
     */
    private Integer version;

    public UUIDDTO(Integer bizType, Integer maxId, Integer stepLength, Integer version) {
        this.bizType = bizType;
        this.maxId = maxId;
        this.stepLength = stepLength;
        this.version = version;
    }
}
