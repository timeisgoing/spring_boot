package com.wgl.cn.singletone;

/**
 * @Description 静态内部类的单例模式
 * @Author guilin wu
 * @Date 2020-05-16 001611:55:34
 * #Version 1.0
 **/

public class InnerClassSingleToneModel {

    //再搞一个类来初始化外面这个了类的实例
    public static class SingletonClassInstance {
        private static final InnerClassSingleToneModel innerClassSingleToneModel = new InnerClassSingleToneModel();
    }

    public static InnerClassSingleToneModel getInstance() {
        System.out.println("getInstance");
        return SingletonClassInstance.innerClassSingleToneModel;
    }

}
