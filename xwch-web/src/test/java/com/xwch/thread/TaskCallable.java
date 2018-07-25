package com.xwch.thread;

import java.util.concurrent.Callable;

/**
 * Created by yfzx-gz-xiewc on 2018/7/23.
 */
public class TaskCallable implements Callable<String> {
    private String content;

    public TaskCallable(String content){
        this.content = content;
    }

    @Override
    public String call() throws Exception {
        return "["+Thread.currentThread().getName()+"]"+content;
    }
}
