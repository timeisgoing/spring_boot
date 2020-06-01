package com.wgl.cn.day1DynamicProxyAndAop.aop;

import com.wgl.cn.day1DynamicProxyAndAop.proxy.IUserDao;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-29 002911:53:40
 * #Version 1.0
 **/
@Service
public class UserService implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据.......");
    }
}
