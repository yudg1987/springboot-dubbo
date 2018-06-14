package com.boot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebTask {
    @Scheduled(cron = "0/5 * * * * ?")
    public void doTask() {
        System.out.println("我做任务了");
    }

}
