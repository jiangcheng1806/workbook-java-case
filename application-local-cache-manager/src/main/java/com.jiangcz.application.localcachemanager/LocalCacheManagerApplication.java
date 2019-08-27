package com.jiangcz.application.localcachemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类名称：LocalCacheManagerApplication<br>
 * 类描述：<br>
 * 创建时间：2019年08月26日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Slf4j
@SpringBootApplication
public class LocalCacheManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalCacheManagerApplication.class,args);
    }
}
