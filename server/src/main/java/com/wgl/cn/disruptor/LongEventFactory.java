package com.wgl.cn.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName
 * @Description 生产event的工厂
 * @Author Administrator
 * @Date 2020-05-14 001420:25:30
 * #Version 1.0
 **/
public class LongEventFactory implements EventFactory<Event> {


    @Override
    public Event newInstance() {
        return new Event();
    }
}
