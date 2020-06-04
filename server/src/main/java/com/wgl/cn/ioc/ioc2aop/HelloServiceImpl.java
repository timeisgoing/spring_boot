package com.wgl.cn.ioc.ioc2aop;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-02 000220:10:35
 * #Version 1.0
 **/

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHelloWorld() {
        System.out.println("HelloServiceImpl实现: hello world!");
    }
}
