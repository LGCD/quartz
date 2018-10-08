package com.didi.lg.rocketmqdemo.demo.controller;

import com.didi.lg.rocketmqdemo.demo.entity.Status;
import com.didi.lg.rocketmqdemo.demo.quartz.Schedual;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lg
 * @date 2018-08-28
 */


@RestController
public class control {

    @Autowired
    Scheduler scheduler;
    @Autowired
    Schedual schedual;

    @RequestMapping("/stop")
    public void stop() {
        try {
            scheduler.shutdown();
            scheduler.clear();
        } catch (Exception e) {

        }
    }


    @RequestMapping("/start")
    public void start() {
        try {
            schedual.start();
        } catch (Exception e) {

        }
    }

    @RequestMapping("/stop1")
    public void update(int x) {
        Status.setStatus(x);
    }

}