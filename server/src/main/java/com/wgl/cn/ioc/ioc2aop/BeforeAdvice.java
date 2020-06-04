package com.wgl.cn.ioc.ioc2aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description T动态代理类
 * @Author guilin wu
 * @Date 2020-06-02 000220:08:52
 * #Version 1.0
 **/

public class BeforeAdvice implements InvocationHandler {
    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标方法执行前调用通知,这个调用对象就是传进来的不是自己生成的,ioc
        methodInvocation.log();
        return method.invoke(bean, args);
    }
}
