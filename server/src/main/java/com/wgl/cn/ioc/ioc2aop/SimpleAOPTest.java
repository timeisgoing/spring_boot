package com.wgl.cn.ioc.ioc2aop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-02 000220:10:12
 * #Version 1.0
 **/

public class SimpleAOPTest {

    public static void main(String[] args) {

        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation methodInvocation = () -> System.out.println("前置方法log: log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        BeforeAdvice beforeAdvice = new BeforeAdvice(helloServiceImpl, methodInvocation);

        // 3. 为目标对象生成代理
        //HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);
        //效果一样,要代理的类加载器,和接口,一起动态代理类,生成代理对象
        HelloService helloServiceImplProxy = (HelloService) Proxy.newProxyInstance(helloServiceImpl.getClass().getClassLoader(),
                                                                                    helloServiceImpl.getClass().getInterfaces(),
                                                                                    beforeAdvice);
        //这个执行就是去了beforeAdvice中invoke(),但是这个invoke中还是先执行MethodInvocation接口的一个实现
        helloServiceImplProxy.sayHelloWorld();
    }


}
