package com.wgl.cn.day2Transaction;

import com.wgl.cn.day1DynamicProxyAndAop.proxy.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000110:00:05
 * #Version 1.0
 **/

public class Test {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        //productService.add();
        productService.save();  //注解事物
    }
}
