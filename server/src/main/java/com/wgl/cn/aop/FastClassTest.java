package com.wgl.cn.aop;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-21 002111:19:29
 * #Version 1.0
 **/

public class FastClassTest {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        FastClassDemo fc = new FastClassDemo();
        fc.invoke(fc.getIndex("f()V"), realObject, null);
        //"f()V"的hashCode就是3078479,根据真实对象类---> 方法名---->方法索引找到真正要执行的方法
    }
}

class  RealObject{
    public void f() {
        System.out.println("f method");
    }

    public void g() {
        System.out.println("g method");
    }
}

/**
 * realObject 确定真实调用的对象
 * index  方法索引,确定调用哪一个方法
 */
class FastClassDemo {
    public Object invoke(int index, Object realObject, Object[] ol) {
        RealObject ro = (RealObject) realObject;
        switch (index) {
            case 1:
                ro.f();
                return null;
            case 2:
                ro.g();
                return null;
        }
        return null;
    }

    public int getIndex(String signature) {
        System.out.println(signature);
        System.out.println(signature.hashCode());
        switch (signature.hashCode()) {
            case 3078479:
                return 1;
            case 3108270:
                return 2;
        }
        return -1;
    }
}
