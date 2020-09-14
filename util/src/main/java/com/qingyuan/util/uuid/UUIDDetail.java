package com.qingyuan.util.uuid;

import com.qingyuan.util.mapper.UUIDMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 唯一ID详细信息类
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-12 11:14
 **/
@Data
public class UUIDDetail {



    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 阈值
     */
    private Double THRE_SHOLD = 0.75;

    /**
     * 现在的值
     */
    private Integer nowUUID;

    /**
     * 最大允许值
     */
    private Integer maxUUID;

    /**
     * 步长
     */
    private Integer stepLength;


    public UUIDDetail(Integer bizType, Integer nowUUID, Integer maxUUID, Integer stepLength) {
        this.bizType = bizType;
        this.nowUUID = nowUUID;
        this.maxUUID = maxUUID;
        this.stepLength = stepLength;
    }


}
