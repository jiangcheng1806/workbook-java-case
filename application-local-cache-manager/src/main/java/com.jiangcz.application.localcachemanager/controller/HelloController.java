package com.jiangcz.application.localcachemanager.controller;

import com.jiangcz.application.localcachemanager.component.AppCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：HelloController<br>
 * 类描述：<br>
 * 创建时间：2019年08月27日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private AppCache appCache;

    @RequestMapping("/")
    public String index(){
        return "unAddedKey" + ":" + appCache.getValueByKey("unAddedKey");
    }
}
