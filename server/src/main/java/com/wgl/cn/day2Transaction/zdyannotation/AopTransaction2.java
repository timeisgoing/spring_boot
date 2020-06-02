package com.wgl.cn.day2Transaction.zdyannotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;


@Component
@Aspect
public class AopTransaction2 {
    @Autowired
    private TransactionUtils3 transactionUtils;

    // 环绕通知 看有没使用注解
    @Around("execution(* com.wgl.cn.day2Transaction.zdyannotation.DaoService.save(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 调用方法之前执行
        System.out.println("开启事物 ");
        TransactionStatus begin = transactionUtils.begin();  //开启事物

        //这里判断此方法有没事物注解,要是有的话就开开启事物
        // // 判断是否有自定义事务注解
        ExtTransation declaredAnnotation = getExtTransaction(proceedingJoinPoint);
        if (declaredAnnotation == null) {
            return;
        }
        // 如果有自定义事务注解，开启事务
        System.out.println("开启事务");
        TransactionStatus transactionStatus = transactionUtils.begin();

        proceedingJoinPoint.proceed();// 执行拦截方法

        // 调用方法之后执行
        System.out.println("提交事物");
        if (transactionStatus != null) {
            transactionUtils.commit(begin);   //提交事物
        }
    }

    public ExtTransation getExtTransaction(ProceedingJoinPoint pjp) throws NoSuchMethodException, SecurityException {
        // 获取方法名称
        String methodName = pjp.getSignature().getName();
        // 获取目标对象
        Class<?> classTarget = pjp.getTarget().getClass();
        // 获取目标对象类型
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        // 获取目标对象方法
        Method objMethod = classTarget.getMethod(methodName, par);
        // // 判断是否有自定义事务注解
        ExtTransation declaredAnnotation = objMethod.getDeclaredAnnotation(ExtTransation.class);

        if (declaredAnnotation == null) {
            System.out.println("您的方法上,没有加入注解!");
            return null;
        }
        return declaredAnnotation;
    }

    // // 异常通知   ,执行的方法产生异常之后就会回滚
    @Around("execution(* com.wgl.cn.day2Transaction.zdyannotation.DaoService.save(..))")
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
