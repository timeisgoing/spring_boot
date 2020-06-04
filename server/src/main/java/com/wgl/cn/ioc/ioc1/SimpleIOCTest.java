package com.wgl.cn.ioc.ioc1;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-02 000219:44:09
 * #Version 1.0
 **/

public class SimpleIOCTest {

    public static void main(String[] args) throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }

    /* 基于解析xml文件,反射实现的ioc
    1.加载配置文件
    2.谁用ioc工具类根据配置生成bean
        加载配置文件;
        拿到每个 <bean> 标签,取得class对象; 根据class对象创建对应的bean
        再遍历这个<bean>里面的<property> 标签,取得bean的属性,利用反射将 bean 相关字段访问权限设为可访问,将<property>中的value设置给name对应属性
        将 bean 注册到 bean 容器中
    3.这时容器中就有相对应的bean了
    */

}
