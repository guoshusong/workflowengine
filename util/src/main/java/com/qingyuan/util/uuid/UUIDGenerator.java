package com.qingyuan.util.uuid;

import com.qingyuan.util.mapper.UUIDMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 水平分表唯一Id生成器
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-12 10:56
 **/
@Component
public class UUIDGenerator {


    @Resource
    private UUIDMapper uuidMapper;

    @Resource
    private UUIDDetailOperator uuidDetailOperator;

    /**
     * 静态变量，面向整个类
     */
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    /**
     * 将uuid数据缓存
     * key bizType 业务类型
     * value UUIDDetail 当前业务类型数据库中UUID的信息
     */
    private static final ConcurrentHashMap<Integer, UUIDDetail> UUID_HASH_MAP = new ConcurrentHashMap<Integer, UUIDDetail>();

    /**
     * 生成分布式唯一uuid
     * @param bizType 业务类型id
     * @return UUID
     */
    public  Integer generateUUID(Integer bizType){
        UUIDDetail uuidDetail;
        Integer uuid = null;
        //如果缓存中已经存在业务类型
        if (UUID_HASH_MAP.containsKey(bizType)){
            uuidDetail = UUID_HASH_MAP.get(bizType);
            //对修改值的操作加锁
            REENTRANT_LOCK.lock();
            try {
                //当前值加一并赋值
                uuid =   uuidDetailOperator.plusNowUUID(uuidDetail);
            }finally {
                REENTRANT_LOCK.unlock();
            }
        }else{
            //如果不存在当前的业务类型，则应该从数据库中获取新值
             UUIDDTO uuiddto = uuidMapper.selectUUID(bizType);
             //此项为空，说明数据库中不存在数据
             if(uuiddto == null){
                 uuidMapper.intiUUID(bizType,100);
                 uuidDetail = new UUIDDetail(bizType,0,100,100);
             }else{
                 //数据库中存在数据，但是缓存中不存在
                 uuidDetail = new UUIDDetail(bizType,uuiddto.getMaxId(),uuiddto.getMaxId()+uuiddto.getStepLength(),uuiddto.getStepLength());
                 uuidMapper.updateUUID(new UUIDDTO(bizType, uuiddto.getMaxId()+uuiddto.getStepLength(), uuiddto.getStepLength(),0));
             }
            uuid =   uuidDetailOperator.plusNowUUID(uuidDetail);
            UUID_HASH_MAP.put(bizType,uuidDetail);
        }
        System.out.println(uuidDetail.toString());
        return uuid;
    }

}
