package com.wgl.cn;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;


/**
 * @ClassName TupleUtil2
 * @Description TODO
 * @Author Administrator
 * @Date 2020-05-08 000815:09:20
 * #Version 1.0
 **/
public class TupleUtil2 {


    // 测试
    public static void main(String[] args) {
        List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
        for (int i = 1; i < 4; i++) {
            GoodsBean goodsBean = new GoodsBean();
            goodsBean.setGoodsId(i);
            goodsBeans.add(goodsBean);
        }
        Integer totalProperty = goodsBeans.size();

        Pair<List<GoodsBean>, Integer> twoTuple = Pair.of(goodsBeans, totalProperty);
        List<GoodsBean> list = twoTuple.getLeft();
        System.out.println(twoTuple);// ([com.wgl.cn.GoodsBean@61a52fbd, com.wgl.cn.GoodsBean@233c0b17, com.wgl.cn.GoodsBean@63d4e2ba],3)
        System.out.println(list);
        System.out.println(twoTuple.getRight());

    }

    //pair的compareTo（） 比较内容是否相等
    @Test
    public void Test() {
        Pair<Integer, Integer> pair = Pair.of(1, 2);
        Pair<Integer, Integer> pair2 = Pair.of(1, 2);
        Pair<Integer, Integer> pair3 = Pair.of(1, 3);
        System.out.println(pair.compareTo(pair2));  //0
        System.out.println(pair == pair2);  //false
        System.out.println(pair.compareTo(pair3));  //-1
    }
}
