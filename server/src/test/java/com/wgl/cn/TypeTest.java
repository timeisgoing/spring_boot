package com.wgl.cn;

import org.junit.Test;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-25 002509:53:20
 * #Version 1.0
 **/

public class TypeTest {

    @Test
    public void test() {
        Integer a = new Integer("1");
        System.out.println("1:" + a);
        change(a);
        System.out.println("2:" + a);


    }


    public void change(int a) {
         a = new Integer("2");
        System.out.println("change:" + a);

    }

}
