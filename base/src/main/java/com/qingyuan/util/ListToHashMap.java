package com.qingyuan.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将List转换为HashMap
 * @program: workflowengine
 * @author: GuoShuSong
 * @create: 2020-09-15 16:33
 **/
@Component
public class ListToHashMap {

    /**
     * 将list转换为hashmap
     * 生成的mapkey值
     * @param keyName key对应的参数名称
     * @param list 包含众多对象的集合
     * @param keyIsNumber key是否是整数类型
     * @param className list中存储的对象的类名
     * @return 返回的k-v:String类型的key值-list对象
     */
    public Map<Object,Object> listToHashMap(String keyName,String className,boolean keyIsNumber,List list) {
        Map<Object ,Object> resultMap= new HashMap<>();
        int start = className.length()+1;
        //keyName在字符串数组中占第几个位置
        int position = -1;
        for (Object object:
             list) {
            //先将对象变成字符串
            //UUIDDetail(bizType=0, THRE_SHOLD=0.75, nowUUID=1101, maxUUID=1300, stepLength=100)
            String temp = object.toString();
            //截断类名和括号，变成bizType=0, THRE_SHOLD=0.75, nowUUID=1101, maxUUID=1300, stepLength=100
            //包括 不包括
            temp = temp.substring(start,temp.length()-1);
            //用“,”分割,得到每一个 属性名=值 的字符串数组
            String[] split=  temp.split(",");
            //如果position为空,说明还没有找到过参数的位置
            if (position == -1){
                for (String filed:
                        split) {
                    position++;
                    if (filed.contains(keyName)){
                        break;
                    }
                }
            }
            //属性名 = 值
            String filed = split[position];
            String[] filedSplit = filed.split("=");
            if (keyIsNumber){
                resultMap.put(Integer.parseInt(filedSplit[1]),object);
            }else{
                resultMap.put(filedSplit[1],object);
            }
        }
        return resultMap;
    }
}
