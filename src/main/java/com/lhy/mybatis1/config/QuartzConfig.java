package com.lhy.mybatis1.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail testTaskDetail() {
        return JobBuilder.newJob(TestTask.class).withIdentity("uploadTask").storeDurably().build();
    }

//    @Bean
//    public Trigger testTaskTrigger() {
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(testTaskDetail())
//                .withIdentity("uploadTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
}
