package com.wgl.cn.day1DynamicProxyAndAop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-21 002114:23:02
 * #Version 1.0
 **/

public class JDKProxyAop implements InvocationHandler {

    private Object target; // 代理对象
    private BeforeFunction before; //针对代理对象的增强方法

    public JDKProxyAop(Object target) {  //代理对象放过构造函数传进来
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------JDKProxy-------调用开始处理--------------");
        if (before != null) {
            System.out.println("执行增强方法...");
            before.before();
        }
        Object resault = method.invoke((target));
        System.out.println("---------------JDKProxy--------调用结束处理--------------");

        return resault;
    }

    public void setBefore(BeforeFunction before) {
        this.before = before;
    }
}

