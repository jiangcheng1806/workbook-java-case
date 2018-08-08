package com.jiangcheng.factory;

import com.jiangcheng.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：InstanceCarFactory<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class InstanceCarFactory {
    private Map<Integer,Car> cars;
    public InstanceCarFactory(){
        cars = new HashMap<>(2);
        cars.put(1,new Car(1,"奥迪"));
        cars.put(2,new Car(2,"奥拓"));
    }
    public Car getCar(int num){
        return cars.get(num);
    }
}
