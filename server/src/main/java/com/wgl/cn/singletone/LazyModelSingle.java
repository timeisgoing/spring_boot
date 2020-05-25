package com.wgl.cn.singletone;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-16 001611:42:28
 * #Version 1.0
 **/

public class LazyModelSingle {

    private static LazyModelSingle single;

    public synchronized static LazyModelSingle getLazyModelSingle() {
        if (single == null) {
            single = new LazyModelSingle();
        }
        return single;
    }
}
