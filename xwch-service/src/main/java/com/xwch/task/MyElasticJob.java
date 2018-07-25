package com.xwch.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.Date;

/**
 * Created by yfzx-gz-xiewc on 2018/1/5.
 */
public class MyElasticJob implements SimpleJob {


    public void execute(ShardingContext shardingContext) {
        System.out.println("task is running-->"+shardingContext.toString());
        switch (shardingContext.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                System.out.println("0--->"+new Date().toString());
                break;
            case 1:
                // do something by sharding item 1
                System.out.println("1--->"+new Date().toString());
                break;
            case 2:
                // do something by sharding item 2
                System.out.println("2--->"+new Date().toString());
                break;
            // case n: ...
        }
    }
}
