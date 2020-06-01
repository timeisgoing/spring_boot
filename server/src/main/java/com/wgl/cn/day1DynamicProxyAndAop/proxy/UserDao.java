package com.wgl.cn.day1DynamicProxyAndAop.proxy;


import com.wgl.cn.day1DynamicProxyAndAop.proxy.IUserDao;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据.......");
    }
}
