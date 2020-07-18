package com.ssm.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduleService {
    @Scheduled(cron = "0/10 * * * * ?")
    public void testTask() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()) + "--------" + "任务1：每隔10秒执行一次");

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void testTask2() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()) + "--------" + "任务2：每隔5秒执行一次");

    }
}
