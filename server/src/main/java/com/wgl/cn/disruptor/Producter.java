package com.wgl.cn.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @ClassName Producter
 * @Description TODO 生产者
 * @Author Administrator
 * @Date 2020-05-14 001420:28:31
 * #Version 1.0
 **/
public class Producter {
    //搞一个ringBuffer，通过构造方法注入
    public final RingBuffer<Event> ringBuffer;

    public Producter(RingBuffer<Event> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    //发送事件
    //ByteBuffer 一种nio的实现类，类似的还设有intBuffer，LongBuffer,short*,long*等
    public void onData(ByteBuffer byteBuffer) {
        long sequence = 0L;
        try {
            // 1.ringBuffer 事件队列 下一个槽  ，也就是取得一个游标的地址
            sequence = ringBuffer.next();
            //2.取出空的事件队列
            Event event = ringBuffer.get(sequence);

            //  byteBuffer.getLong(0); 读取给定索引处的 8 个字节，根据当前的字节顺序将它们组成 long 值；取出传入的Bytrbuffer中的第一个数据 ，插入到事件中
            long data = byteBuffer.getLong(0);
            // 往事件中插入数据
            event.setValue(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产这准备发送数据");
            //4.发布事件
            ringBuffer.publish(sequence);

        }

    }


}
