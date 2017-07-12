package com.redis.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Movie on 2017/7/12.
 */
@Component
public class SchedulleTest {
    @Scheduled(cron = "*/5 * * * * ?")
    public void testSchedule() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
