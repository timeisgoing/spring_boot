package com.wgl.cn.disruptor;

/**
 * @ClassName Event
 * @Description TODO 定义一个event这是通过disruptor来交换的数据类型
 * @Author Administrator
 * @Date 2020-05-14 001420:23:30
 * #Version 1.0
 **/
public class Event {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
