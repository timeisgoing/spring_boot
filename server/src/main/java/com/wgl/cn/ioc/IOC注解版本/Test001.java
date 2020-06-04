package com.wgl.cn.ioc.IOC注解版本;


/**
 * @Description
 * @Author guilin wu
 * @Date 2020-06-03 000316:00:37
 * #Version 1.0
 * 自己实现一个注解注入bean
 **/

public class Test001 {
    public static void main(String[] args) throws Exception {

        /* * 思路: 1.使用java反射机制获取当前类下的所有类
         * 2.判断类上是否存在注入bean的注解
         * 3.使用java反射机制进行初始化*/
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("com.wgl.cn.ioc.IOC注解版本");//设置扫描范围
        UserService userService = (UserService) app.getBean("userServiceImpl"); //
        userService.add();
    }
}
