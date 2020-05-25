package com.wgl.cn.singletone;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-16 001611:46:15
 * #Version 1.0
 **/

public class HungrySingleModel {
    private static HungrySingleModel single = new HungrySingleModel();

    public static HungrySingleModel getInstance() {
        return single;
    }
}
