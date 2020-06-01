package com.wgl.cn.day2Transaction.zdyannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000120:40:40
 * #Version 1.0
 **/

@Component()
@Scope("prototype") // 设置成原型解决线程安全
public class TransactionUtils3 {

    private TransactionStatus transactionStatus;
    // 获取事务源
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // 开启事务
    public TransactionStatus begin() {
        transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }

    // 提交事务
    public void commit(TransactionStatus transaction) {
        dataSourceTransactionManager.commit(transaction);
    }

    // 回滚事务
    public void rollback() {
        System.out.println("rollback");
        dataSourceTransactionManager.rollback(transactionStatus);
    }

}
