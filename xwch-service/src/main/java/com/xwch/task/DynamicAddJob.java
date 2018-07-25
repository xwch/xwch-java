package com.xwch.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.exception.JobSystemException;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.internal.config.ConfigurationService;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yfzx-gz-xiewc on 2018/1/5.
 */
public class DynamicAddJob implements SimpleJob{
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /***
     * @param date 时间
     * @return cron类型的日期
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        System.out.println("formatTimeStr--->"+formatTimeStr);
        return formatTimeStr;
    }





    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()){
            case 0:
                System.out.println("doing sharding 0...job name is "+shardingContext.getJobName());
                // do something by sharding item 0
                break;
            case 1:
                System.out.println("doing sharding 1...job name is "+shardingContext.getJobName());
                // do something by sharding item 1
                break;
        }
    }




    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-quartz.xml");
        ZookeeperRegistryCenter zookeeperRegistryCenter = context.getBean(ZookeeperRegistryCenter.class);
        long now = System.currentTimeMillis();
            //String cron = getCron(new Date(now + (i + 1) * 50000));
        String cron = "48 49 16 07 01 ? 2018";
            JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("dynamicDemoJob1-", cron, 2).build();
            SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfig, DynamicAddJob.class.getCanonicalName());
        //获取远程节点
        ConfigurationService configService = new ConfigurationService(zookeeperRegistryCenter,simpleJobConfig.getCoreConfig().getJobName());
        LiteJobConfiguration zkJobConfiguration = configService.load(false);
        if (zkJobConfiguration != null){
            System.out.println("LiteJobConfiguration-->"+zkJobConfiguration.toString());

        }
            JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfig).build());
            try {
                jobScheduler.init();
            }catch (JobSystemException e){
                e.printStackTrace();
            }

    }
}
