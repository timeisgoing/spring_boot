package com.wgl.cn.day2Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000109:53:43
 * #Version 1.0
 **/
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private TransactionUtils transactionUtils;
//编程事物
/*    public void add() {
        TransactionStatus ds = null;
        try {
            ds = transactionUtils.begin();
            productDao.add(8 + "", 88 + "");
            int i = 1 / 0;
            productDao.add("9", "99");
            transactionUtils.commit(ds);
        } catch (Exception e) {
            e.printStackTrace();
            if (ds != null) {
                transactionUtils.rollback(ds);
            }
            return;
        }

    }*/

    /*Initiating transaction rollback
10:16:29.925 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager -
Rolling back JDBC transaction on Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@3a3ed300
*/


    //aop事物
    //service的异常不建议处理,抛出来.
    public void add() throws Exception {

        productDao.add("12", "12");
        int i = 1 / 0;
        productDao.add("9", "99");

    }
}
