package com.qingyuan.util.uuid;

import com.qingyuan.util.mapper.UUIDMapper;
import lombok.Data;

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

    @Resource
    private UUIDMapper uuidMapper;

    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 阈值
     */
    private static double THRESHOLD = 0.75;

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

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public UUIDDetail(Integer bizType, Integer nowUUID, Integer maxUUID, Integer stepLength) {
        this.bizType = bizType;
        this.nowUUID = nowUUID;
        this.maxUUID = maxUUID;
        this.stepLength = stepLength;
    }

    /**
     * 将现在的最大uuid加一
     */
    public Integer plusNowUUID() {
        if (nowUUID >= maxUUID * THRESHOLD) {
            reentrantLock.lock();
            try {
                if (nowUUID >= maxUUID * THRESHOLD) {
                    //达到阈值，应当进行扩容操作
                    //并发
                    //此处扩容操作应当如何保证数据一致性
                    //扩大最大值的容量
                    uuidMapper.plusMaxID(this.bizType);
                    //并申请最大的容量
                    this.maxUUID = this.maxUUID+ stepLength;
                }
            }finally {
                reentrantLock.unlock();
            }
        }
        this.nowUUID++;
        return this.nowUUID;
    }
}
