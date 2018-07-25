package com.xwch.task.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.internal.schedule.JobRegistry;

/**
 * Created by yfzx-gz-xiewc on 2018/1/5.
 */
public class MyElasticJobListener implements ElasticJobListener{
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        //在job跑之前先查一次数据库，如果新旧配置不一样，则停止旧的job，建新的job
        String jobName = shardingContexts.getJobName();
        System.out.println("jobName--->"+jobName+"----beforeJobExecuted");
        System.out.println(jobName+"isShutdown: "+JobRegistry.getInstance().isShutdown(jobName));
        JobRegistry.getInstance().shutdown(jobName);
        System.out.println(jobName+"isShutdown: "+JobRegistry.getInstance().isShutdown(jobName));
    }

    public void afterJobExecuted(ShardingContexts shardingContexts) {
        String jobName = shardingContexts.getJobName();
        System.out.println("jobName--->"+jobName+"----afterJobExecuted");
    }
}
