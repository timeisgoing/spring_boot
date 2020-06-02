package com.wgl.cn.day2Transaction.zdyannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD}) // 注解的作用范围
@Retention(RetentionPolicy.RUNTIME)   //声明周期,运行时
public @interface ExtTransation {
    int userId() default 0;
    String username() default "默认";
}




