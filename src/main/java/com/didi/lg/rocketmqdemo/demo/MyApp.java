package com.didi.lg.rocketmqdemo.demo;

import com.didi.lg.rocketmqdemo.demo.quartz.Schedual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lg
 * @date 2018-08-29
 */
// @Component
public class MyApp implements ApplicationRunner {


    @Autowired
    Schedual schedual;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        schedual.start();
    }
}