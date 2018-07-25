package com.xwch.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yfzx-gz-xiewc on 2018/6/23.
 */
public class ThreadTest{

    private final int mCount = 5;
    private final CountDownLatch countDownLatch;
    protected ThreadPoolExecutor writeFileExecutor;

    public ThreadTest()
    {
        //初始化CyclicBarrier
        countDownLatch = new CountDownLatch(1);
        writeFileExecutor = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue());

        for (int i = 0; i < mCount; i++)
        {
            //启动工作线程
            writeFileExecutor.execute(new Walker(countDownLatch, i));
        }
    }

    //工作线程
    class Walker implements Runnable
    {
        private final CountDownLatch countDownLatch;
        private final int mThreadIndex;

        Walker(final CountDownLatch countDownLatch, final int threadIndex)
        {
            this.countDownLatch = countDownLatch;
            this.mThreadIndex = threadIndex;
        }

        @Override
        public void run()
        {
            // TODO Auto-generated method stub
            System.out.println("Thread " + mThreadIndex + " is running...");
            // 执行任务
            try
            {
                TimeUnit.MILLISECONDS.sleep(1000);
                // do task
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("currentQueue-->"+writeFileExecutor.getQueue().size());
            if (writeFileExecutor.getQueue().size()==0){
                countDownLatch.countDown();
            }
        }

    }

        public static void main(String[] args)
        {
            System.out.println(test());
        }


    public static boolean test(){
        try {
            ThreadTest threadTest= new ThreadTest();
            System.out.println("---等待---");
            threadTest.countDownLatch.await();
            System.out.println("---主线程 往下执行---");
            Thread.sleep(2000L);
            return true;
            //throw new RuntimeException("exception");
        }catch (Exception e){
            System.out.println("异常");
            return false;
        }finally {
            System.out.println("finally");
        }
    }
}
