package com.wgl.cn.day2Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000109:43:44
 * #Version 1.0
 **/
@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String id, String money) {
        String sql = "INSERT INTO `buyflow`.`a`(`id`, `money`) VALUES (" + id + ", " + money + "); ";
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }


}
