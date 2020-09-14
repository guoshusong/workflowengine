package com.qingyuan.util.uuid;

import com.qingyuan.util.mapper.UUIDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-14 19:48
 **/
@Component
public class UUIDDetailOperator {


    @Resource
    private UUIDMapper uuidMapper;


    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    /**
     * 将现在的最大uuid加一
     */
    public Integer plusNowUUID(UUIDDetail uuidDetail) {
        if (uuidDetail.getNowUUID() >= uuidDetail.getMaxUUID() * uuidDetail.getTHRE_SHOLD()) {
            REENTRANT_LOCK.lock();
            try {

                if (uuidDetail.getNowUUID() >= uuidDetail.getMaxUUID() * uuidDetail.getTHRE_SHOLD()) {
                    //达到阈值，应当进行扩容操作
                    //并发
                    //此处扩容操作应当如何保证数据一致性
                    //扩大最大值的容量
                    uuidMapper.plusMaxID(uuidDetail.getBizType());
                    //并申请最大的容量
                    uuidDetail.setMaxUUID(uuidDetail.getMaxUUID()+uuidDetail.getStepLength());
                }
            }finally {
                REENTRANT_LOCK.unlock();
            }
        }
        uuidDetail.setNowUUID(uuidDetail.getNowUUID()+1);
        return uuidDetail.getNowUUID();
    }
}
