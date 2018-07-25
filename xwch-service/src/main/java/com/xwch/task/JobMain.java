package com.xwch.task;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.strategy.impl.AverageAllocationJobShardingStrategy;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.xwch.task.listener.MyElasticJobListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**每台作业节点均执行的监听
 * http://elasticjob.io/docs/elastic-job-lite/02-guide/job-listener/
 * Created by yfzx-gz-xiewc on 2018/1/5.
 */
public class JobMain {
    public static void main(String[] args) {
        new JobScheduler(createRegistryCenter(), createJobConfiguration(), new MyElasticJobListener()).init();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
/*        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("zk_host:2181", "elastic-job-demo"));
        regCenter.init();*/
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-quartz.xml");
        ZookeeperRegistryCenter regCenter = context.getBean(ZookeeperRegistryCenter.class);

        return regCenter;
    }

    private static LiteJobConfiguration createJobConfiguration() {
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("demoSimpleJob", "0/15 * * * * ?", 3).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyElasticJob.class.getCanonicalName());
        // 定义Lite作业根配置
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration
                .newBuilder(simpleJobConfig)
                .jobShardingStrategyClass(AverageAllocationJobShardingStrategy.class.getCanonicalName())
                .build();

        return simpleJobRootConfig;

    }
}
