package com.xwch.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yfzx-gz-xiewc on 2018/7/23.
 */
public class Test {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
            final ThreadPoolExecutor executorWrite = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
            for (int i = 0; i < 10; i++) {
                final int finalI = i;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        List<Future<String>> futureTask = new ArrayList<>();
                        //System.out.println("我的内容为：["+Thread.currentThread().getName()+"]");
                        for (int j = finalI; j < finalI+3; j++) {
                            String content = "["+Thread.currentThread().getName()+"_"+ finalI+"_"+j+"]";
                            //System.out.println("content-->"+content);
                            futureTask.add(executorWrite.submit(new TaskCallable(content)));
                        }

                        for (Future<String> future: futureTask) {
                            try {
                                System.out.println("future-->["+Thread.currentThread().getName()+"]"+(String) future.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
            Thread.sleep(10000);
            executor.shutdownNow();
            executorWrite.shutdownNow();
            System.out.println("主线程运行结束");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
