package com.wgl.cn.day1DynamicProxyAndAop.proxy;

/**
 * @Description TODO 静态代理
 * @Author guilin wu
 * @Date 2020-05-19 001914:24:34
 * #Version 1.0
 **/

public class StaticProxy {

    private IUserDao target;

    public StaticProxy(IUserDao userDao) {
        this.target = userDao;
    }

    public void save() {
        System.out.println("开启事物...");
        target.save();
        System.out.println("关闭事物...");

    }
}
