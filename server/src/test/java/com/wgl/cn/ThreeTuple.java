package com.wgl.cn;

/**
 * @ClassName ThreeTuple
 * @Description TODO
 * @Author Administrator
 * @Date 2020-05-08 000815:12:08
 * #Version 1.0
 **/

/**
 * 三个元素的元组，用于在一个方法里返回三种类型的值
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }
}