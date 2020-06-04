package com.wgl.cn.ioc.ioc2aop;

import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-02 000220:09:24
 * #Version 1.0
 **/

public class SimpleAOP {
    public static Object getProxy(Object bean, BeforeAdvice advice) {
        ////搞一个代理对象出来,需要要代理的类的类加载器,他的接口,还有一个动态代理类
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }

}
