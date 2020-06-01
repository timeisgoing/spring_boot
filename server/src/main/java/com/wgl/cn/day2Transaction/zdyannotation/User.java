package com.wgl.cn.day2Transaction.zdyannotation;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000120:27:57
 * #Version 1.0
 **/

public class User {
    @Add(userId = 1, username = "lucy")
    public void add() {

    }

    //注解检查方法,提供默认值
    //反射--获取当前类---当前类方法---那个方法上有注解 ---直接取注解中的值
    //那么事物和注解有什么关系呢?使用注解可以简化注解,我们可以在每个方法执行时做aop切面检查,aop中通过反射盘算当前方法上有没有事物注解,有就开启事物
    public static void main(String[] args) throws ClassNotFoundException {
        // 怎么样获取到方法上注解信息 反射机制
        Class<?> forName = Class.forName("com.wgl.cn.day2Transaction.zdyannotation.User");
        // 获取到当前类（不包含继承）所有的方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 获取该方法上是否存在注解
            System.out.println("####方法名称" + method.getName());
            Add addAnnotation = method.getDeclaredAnnotation(Add.class);
            if (addAnnotation == null) {
                // 该方法上没有注解
                System.out.println("该方法上没有加注解..");
                continue;
            }
            // 在该方法上查找到该注解
            System.out.println("userId:" + addAnnotation.userId());
            System.out.println("userName:" + addAnnotation.username());


        }
    }


}
