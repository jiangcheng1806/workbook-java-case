package com.jiangcheng.test;

import com.jiangcheng.theory.junit.Case;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 类名称：ApplicationTest<br>
 * 类描述：<br>
 * 创建时间：2018年05月10日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class ApplicationTest {

    @Test
    public void begin() {
        Case application = new Case();
        assertEquals(application.begin(),"Application is begining!");
    }

    @Test
    public void end() {
        Case application = new Case();
        assertEquals(application.end(),"Application is ending!");
    }
}