package com.wgl.cn.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description cglib
 * @Author guilin wu
 * @Date 2020-05-21 002110:07:45
 * #Version 1.0
 **/

public class CglibProxy implements MethodInterceptor {
    //要代理的类
    private Object object;



    public Object getObject(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();  //创建对象
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事物");
        Object result = methodProxy.invoke(object, args);
        System.out.println("关闭事物");
        // 返回代理对象
        return result;
    }


}
