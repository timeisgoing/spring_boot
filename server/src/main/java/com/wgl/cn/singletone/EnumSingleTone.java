package com.wgl.cn.singletone;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-16 001615:39:47
 * #Version 1.0
 **/

public class EnumSingleTone {

    //内部类 枚举
    private static enum SinglrDemo {
        INSTANE;
        private EnumSingleTone enumSingleTone;

        //枚举的构造中实例化外面我们要单例的这个类
        SinglrDemo() {
            enumSingleTone = new EnumSingleTone();
        }

        //取得外面的单例
        public EnumSingleTone get() {
            return enumSingleTone;
        }
    }

    public EnumSingleTone get() {
        return SinglrDemo.INSTANE.get();
    }
}
/*枚举的实例最安全啊
* 不怕反射取到
* 因为枚举反编译之后是abstract的
*
* 但是抽象类真的不能实例化吗 ？
* 抽象类在没有实现所有的抽象方法前是不可以通过new来构建该对象的，但是抽象方法却是可以有自己的构造方法的
* 抽象类其实是可以实例化的，但是他的实例化方式不是通过new方式来创建对象，而是通过父类的引用来指向子类的实例来间接地实现父类的实例化（因为子类要实例化前，一定会先实例化他的父类。这样创建了继承抽象类的子类的对象，也就把其父类（抽象类）给实例化了）.但是：接口是不能被实例化的（接口压根就没有构造函数）。


* */