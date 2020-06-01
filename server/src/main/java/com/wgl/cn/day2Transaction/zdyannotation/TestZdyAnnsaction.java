package com.wgl.cn.day2Transaction.zdyannotation;

import com.wgl.cn.day2Transaction.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000120:58:06
 * #Version 1.0
 **/

public class TestZdyAnnsaction {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DaoService daoService = (DaoService) applicationContext.getBean("daoService");
        try {
            daoService.save();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
