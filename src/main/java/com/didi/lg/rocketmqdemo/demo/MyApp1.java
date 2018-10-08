package com.didi.lg.rocketmqdemo.demo;

import com.didi.lg.rocketmqdemo.demo.entity.Status;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lg
 * @date 2018-08-29
 */
@Component
public class MyApp1 implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (Status.status == 1) {
            System.out.println("------------> 1");
            Thread.sleep(1000);
        }
    }
}