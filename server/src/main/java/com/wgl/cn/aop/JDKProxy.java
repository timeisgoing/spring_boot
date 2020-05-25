package com.wgl.cn.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-19 001914:26:47
 * #Version 1.0
 **/

public class JDKProxy implements InvocationHandler {

    private Object target; // 代理对象

    public JDKProxy(Object target) {  //代理对象放过构造函数传进来
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------JDKProxy-------调用开始处理--------------");
        Object resault = method.invoke((target));
        System.out.println("---------------JDKProxy--------调用结束处理--------------");

        return resault;
    }
}
