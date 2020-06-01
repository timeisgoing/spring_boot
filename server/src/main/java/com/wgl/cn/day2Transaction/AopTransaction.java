package com.wgl.cn.day2Transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Description 变成事物太麻烦了
 * 利用aop,搞一个环绕方法在方法前后执行事物检查
 * @Author guilin wu
 * @Date 2020-06-01 000110:20:26
 * #Version 1.0
 **/
@Component
@Aspect
public class AopTransaction {
    @Autowired
    private TransactionUtils transactionUtils;

    // 环绕通知 在方法之前和之后处理事情
    @Around("execution(* com.wgl.cn.day2Transaction.ProductService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 调用方法之前执行
        System.out.println("开启事物 ");
        TransactionStatus begin = transactionUtils.begin();  //开启事物

        proceedingJoinPoint.proceed();// 代理调用方法,就是上面配置的ProductService.add(). 注意：如调用方法抛出溢出不会执行后面代码

        // 调用方法之后执行
        System.out.println("提交事物");
        transactionUtils.commit(begin);   //提交事物

    }

    // // 异常通知
    @AfterThrowing("execution(* com.wgl.cn.day2Transaction.ProductService.add(..))")
    public void afterThrowing() {
        System.out.println("回滚");
        // 获取程序当前事务 进行回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    //针对当前事物的异常产生回滚
    // 我发现即使事物没有回滚,发生报错也不会提交,这是因为已经开启乐意一个事物,报错,就没有提交
    //虽然结果上看一样,但是这个事物一直占用着内存,当错误过多时,栈(应该是栈)就炸了
    //所以事物一定要有回滚机制
}
