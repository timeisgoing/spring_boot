package com.wgl.cn.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-14 001421:08:01
 * #Version 1.0
 **/

public class Dojob {



    public static void main(String[] args) {
        // 1.创建一个可缓存的线程 提供线程来出发Consumer 的事件处理
        ExecutorService executor = Executors.newCachedThreadPool();
        // 2.创建工厂  生产者
        EventFactory<Event> eventFactory = new LongEventFactory();
        // 3.创建ringBuffer 大小 ---------------------------以上是准备生产者条件
        int ringBufferSize = 1024 * 1024; // ringBufferSize大小一定要是2的N次方
        // 4.创建 Disruptor(对象生产者,ringBuffer大小,执行线程池,ProducerType.SINGLE ,消费者的等待策略)-------------------------创建disruptor了
        Disruptor<Event> disruptor = new Disruptor<Event>(eventFactory, ringBufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());

        // 5.连接消费端ConsumerEventHandler
        disruptor.handleEventsWith(new ConsumerEventHandler());
        // 6.启动disruptor
        disruptor.start();


        // 7.创建RingBuffer容器         ----------------------存放信息的ringbuffer容器---------------
        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        // 8.创建生产者,此时生产者绑定了这个dingBuffer了
        Producter producer = new Producter(ringBuffer);
        // 9.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (int i = 1; i <= 100; i++) {
            byteBuffer.putLong(0, i);   //往buyteBuffer位置0处中写入数据
            producer.onData(byteBuffer);   //  生产者会往刚刚绑定的RingBuffer中写入数据
        }
        //10.关闭disruptor和executor
        disruptor.shutdown();
        executor.shutdown();
    }


}
