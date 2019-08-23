package com.jiangcz.factory;

import com.jiangcz.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：StaticFactory<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class StaticFactory {
    private static Map<Integer,Car> cars;
    static {
        cars = new HashMap<>(2);
        cars.put(1,new Car(1,"奥迪"));
        cars.put(2,new Car(2,"奥拓"));
    }
    public static Car getCar(int num){
        return cars.get(num);
    }
}
