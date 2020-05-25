package com.wgl.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TupleUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2020-05-08 000815:11:00
 * #Version 1.0
 **/
public class TupleUtil {
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }

    // 测试
    public static void main(String[] args) {
        List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
        for(int i = 1; i < 26; i++) {
            GoodsBean goodsBean = new GoodsBean();
            goodsBean.setGoodsId(i);
            goodsBeans.add(goodsBean);
        }
        Integer totalProperty = 47;
//      TupleUtil<List<GoodsBean>, Integer> tupleUtil = new TupleUtil<List<GoodsBean>, Integer>(goodsBeans, totalProperty);
        TwoTuple<List<GoodsBean>, Integer> twoTuple = TupleUtil.tuple(goodsBeans, totalProperty);
        List<GoodsBean> list = twoTuple.first;
        System.out.println(list);
        System.out.println(twoTuple.second);
    }
}
