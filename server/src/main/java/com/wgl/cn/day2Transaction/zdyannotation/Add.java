package com.wgl.cn.day2Transaction.zdyannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(value = {ElementType.METHOD, ElementType.TYPE}) // 注解的作用范围
@Retention(RetentionPolicy.RUNTIME)   //声明周期,运行时
public @interface Add {

    int userId() default 0;

    String username() default "默认";
}

// userId()这个跟方法一样的就是我要限定的方法的参数
