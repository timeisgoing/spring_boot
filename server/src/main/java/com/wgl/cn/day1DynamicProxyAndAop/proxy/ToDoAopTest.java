package com.wgl.cn.day1DynamicProxyAndAop.proxy;

import com.wgl.cn.day1DynamicProxyAndAop.proxy.JDKProxyAop;

import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-21 002114:24:30
 * #Version 1.0
 **/

public class ToDoAopTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        JDKProxyAop jdkProxyAop = new JDKProxyAop(userDao);
        jdkProxyAop.setBefore(new BeforeFunction() {
            @Override
            public void before() {
                System.out.println("保存之前先检查数据...");
            }
        });
        IUserDao o = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), jdkProxyAop);
        o.save();
    }
}
