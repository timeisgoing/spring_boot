package com.wgl.cn.day2Transaction.zdyannotation;

import com.wgl.cn.day2Transaction.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-01 000120:58:59
 * #Version 1.0
 **/
@Service
public class DaoService {

    @Autowired
    private ProductDao productDao;


    @ExtTransation
    public void save() throws Exception {
        productDao.save("12", "12");
        int i = 1 / 0;
        productDao.save("9", "99");
    }
}
