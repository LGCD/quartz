package com.didi.lg.rocketmqdemo.demo.quartz;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import com.didi.lg.rocketmqdemo.demo.timer.LogTimer;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lg
 * @date 2018-08-28
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class Schedual {

    @Autowired
    Scheduler scheduler;

    public void start() throws Exception {
        long startAtTime = System.currentTimeMillis() + 1000 * 2;

        //任务名称
        String name = "output";
        //任务所属分组
        String group = "test";
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(LogTimer.class).withIdentity(name, group)
            .build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity(name, group)
            .startAt(new Date(startAtTime))
            .withSchedule(simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever())
            .build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
}