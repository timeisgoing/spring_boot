package com.wgl.cn.day2Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @Description 使用编程事务实现，手动事务 begin、commit、rollback
 * @Author guilin wu
 * @Date 2020-05-26 002614:14:59
 * #Version 1.0
 * 这里的事物是使用DataSourceTransactionManager来具体实现的,他就是数据库jdbc事物实现
 * spring的事物是一个框架,具体的实现看具体的实现,典型的数据库会有相关的实现
 **/
@Component    //注入到容器中去,主要不要使用单例模式
public class TransactionUtils {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;


    // 开启事务
    public TransactionStatus begin() {
        //DefaultTransactionAttribute 设置事物默认的状态
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    // 提交事务
    public void commit(TransactionStatus transactionStatus) {
        dataSourceTransactionManager.commit(transactionStatus);
    }

    // 回滚事务
    public void rollback(TransactionStatus transactionStatus) {
        dataSourceTransactionManager.rollback(transactionStatus);
    }


}
