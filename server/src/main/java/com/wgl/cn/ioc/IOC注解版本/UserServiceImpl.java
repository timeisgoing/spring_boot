package com.wgl.cn.ioc.IOC注解版本;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-03 000319:37:37
 * #Version 1.0
 **/
@ExtService
public class UserServiceImpl  implements  UserService{
    @Override
    public void add() {
        System.out.println("UserServiceImpl....add()  ");
    }
}
