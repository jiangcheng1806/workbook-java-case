package com.chanspace.LRU;

import org.apache.log4j.Logger;

import java.util.Map;
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



    }

    //获取cache长度
    public int getSize(){
        return cacheItems.size();
    }
}
