package com.didi.lg.rocketmqdemo.demo.timer;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author lg
 * @date 2018-08-28
 */

@Component
public class LogTimer extends QuartzJobBean {

    static Logger logger = LoggerFactory.getLogger(LogTimer.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
        throws JobExecutionException {
        Date date = new Date();
        logger.info("this is one {}", new Date());
    }
}