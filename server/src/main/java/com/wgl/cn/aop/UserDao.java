package com.wgl.cn.aop;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-19 001914:23:36
 * #Version 1.0
 **/

public class UserDao implements com.wgl.cn.aop.IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据.......");
    }
}
