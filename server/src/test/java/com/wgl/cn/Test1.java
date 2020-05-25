package com.wgl.cn;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author Administrator
 * @Date 2020-05-14 001415:24:24
 * #Version 1.0
 **/
public class Test1 implements Runnable {

    //public class FalseSharing
    public final static long ITERATIONS = 500L * 1000L * 100L;
    private int arrayIndex = 0;

    private static ValuePadding[] longs;

    public Test1(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        for (int i = 1; i < 10; i++) {
            System.gc();
            final long start = System.currentTimeMillis();
            runTest(i);
            System.out.println("Thread num " + i + " duration = " + (System.currentTimeMillis() - start));
        }

    }

    // NUM_THRE数组长度
    private static void runTest(int NUM_THREADS) throws InterruptedException {
        // 两个数组 ，longs和threads，长度都是num_threads

        Thread[] threads = new Thread[NUM_THREADS];
        //new Class[0]表示有零个元素的Class数组，  所以new ValuePadding[NUM_THREADS];就是创建NUM_THREADS个ValuePadding对象组成的数组
        longs = new ValuePadding[NUM_THREADS];

        //longs数组的原始都是ValuePadding对象
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new ValuePadding();
        }
        //threads数组的元素都是thread线程对象       ，这不本来就是嘛，为啥再设置一次- - ！！
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Test1(i));
        }
        //开始
        for (Thread t : threads) {
            t.start();
        }
        //join就是抢占优先权 ，join
        for (Thread t : threads) {
            t.join();
        }
    }
    //这方法没用啊
    public void run() {
        long i = ITERATIONS + 1;
        //将数组的每一个都设置为0
        while (0 != --i) {
            longs[arrayIndex].value = 0L;
        }
    }

    public final static class ValuePadding {
        protected long p1, p2, p3, p4, p5, p6, p7;
        protected volatile long value = 0L;
        protected long p9, p10, p11, p12, p13, p14;
        protected long p15;
    }

    public final static class ValueNoPadding {
        // protected long p1, p2, p3, p4, p5, p6, p7;
        protected volatile long value = 0L;
        // protected long p9, p10, p11, p12, p13, p14, p15;
    }

}
