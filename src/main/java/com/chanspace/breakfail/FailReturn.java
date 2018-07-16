package com.chanspace.breakfail;

/**
 * 类名称：FailReturn<br>
 * 类描述：<br>
 * 创建时间：2018年06月26日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class FailReturn {
    public static void main(String[] args) {
        new FailReturn().foreach();
    }


    public String foreach(){
        for (int j = 0; j < 150 ; j++){
            for (int i = 0; i < 100; i++) {
                if (i == 50){
                    return null;
                }
                System.out.println("it gose to -----------"+i);
            }
        }

        return null;
    }
}
