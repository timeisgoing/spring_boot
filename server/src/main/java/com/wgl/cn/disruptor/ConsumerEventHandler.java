package com.wgl.cn.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Consumer
 * @Description TODO 消费者
 * @Author Administrator
 * @Date 2020-05-14 001420:26:37
 * #Version 1.0
 **/
public class ConsumerEventHandler implements EventHandler<Event> {

    @Override
    public void onEvent(Event event, long l, boolean b) throws Exception {
        System.out.println("消费者:" + event.getValue());
    }



}
