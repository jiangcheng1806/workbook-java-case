package com.chanspace.LRU;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类名称：MyCache<br>
 * 类描述：<br>
 * 创建时间：2018年05月22日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class MyCache{

    //日志记录
    private static final Logger logger = Logger.getLogger(MyCache.class);

    //单例
    private static MyCache myCache;

    private Map<Object,Object> cacheItems;

    //单例私有化构造函数
    private MyCache(){
        cacheItems = new ConcurrentHashMap<>();
    }

    //获取唯一实例
    public static MyCache getInstance(){
        if (myCache == null){
            synchronized (MyCache.class){
                if (myCache == null){
                    myCache = new MyCache();
                }
            }
        }
        return myCache;
    }

    //清空cache
    public void clearCacheItems(){
        cacheItems.clear();
    }

    //刷新cache
    public void refresh(){
        logger.info("Before refreshing Cache size = "+ myCache.getSize());
        //清空缓存
        cacheItems.clear();
        //重新查库
        Map<String,String> mockMap = getMockMap();
        //遍历map
        Set<String> set = mockMap.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            Object key = it.next();
            Object value = mockMap.get(key);
            if (key != null && value != null){
                myCache.putCacheItem(key,value);
            }
        }
        logger.info("After the refresh Cache size = "+ myCache.getSize());
    }

    //获取cache长度
    public int getSize(){
        return cacheItems.size();
    }

    //获取指定cache信息
    public Object getCacheItem(Object key){
        if (cacheItems.containsKey(key)){
            return cacheItems.get(key);
        }
        return null;
    }

    //存放cache信息
    public void putCacheItem(Object key,Object value){
        if (!cacheItems.containsKey(key)){
            cacheItems.put(key,value);
        }
    }

    //获取所有cache信息
    public Map<Object,Object> getCacheItems(){
        return cacheItems;
    }

    public void setCacheItems(Map<Object, Object> cacheItems) {
        this.cacheItems = cacheItems;
    }

    //mock一个map
    public Map<String,String> getMockMap(){
        Map<String,String> mockMap = new ConcurrentHashMap<>(12);
        for (int i = 0; i < 12; i++) {
            mockMap.put("key"+i,"value"+i*i);
        }
        return mockMap;
    }


}
