package com.wgl.cn.aop;

import org.springframework.cglib.core.DebuggingClassWriter;

import java.lang.reflect.Proxy;


/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-19 001914:41:02
 * #Version 1.0
 **/

public class Todo {

    public static void main1(String[] args) {

        //    jdk动态代理

        IUserDao userDao = new UserDao();      //代理对象要实现接口

        JDKProxy jdkProxy = new JDKProxy(userDao);       //传入，创建代理对象
        ClassLoader classLoader = userDao.getClass().getClassLoader();  //要代理类的类加载器
        Class<?>[] interfaces = userDao.getClass().getInterfaces();  // 要代理类实现的接口
        /*设置系统属性，把生成的代理类写入到文件。
        这里再强调一下，JDK动态代理技术是在运行时直接生成类的字节码，并载入到虚拟机执行的。这里不存在class文件的，
        所以我们通过设置系统属性，把生成的字节码保存到文件，用于后面进一步分析。
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IUserDao instance = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, jdkProxy);  //搞一个代理对象出来
        instance.save();  //代理出来的对象干活

        // instance.save(); ----->  最终执行时到了JDKProxy代理对象那里执行的，JDKProxy有通过反射invoke（）调用的原方法

        //JDK动态代理技术可以为一组接口（IUserDao）生成代理类，
        // 这个代理类也就是一层壳， 通过提供一个构造函数传入InvocationHandler实例（这里的JDKProxy），然后将方法的具体实现交给它（invoke反射执行）。
    }

    //cglib
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\code");
        UserDao userdao = (UserDao) new CglibProxy().getObject(new UserDao());
        userdao.save();

    }
}
