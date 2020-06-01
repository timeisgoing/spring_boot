package com.wgl.cn.day1DynamicProxyAndAop.aop;


import com.wgl.cn.day1DynamicProxyAndAop.proxy.IUserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-29 002911:54:18
 * #Version 1.0
 **/

public class TestAop_1 {
    //测试aop   AopLog
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IUserDao userService = (IUserDao) applicationContext.getBean("userService");
        userService.save();
    }
}
/*环绕通知 调用方法之前执行
前置通知 在方法之前执行...
保存数据.......
环绕通知 调用方法之后执行
前置通知 在方法之后执行...
运行通知
*/