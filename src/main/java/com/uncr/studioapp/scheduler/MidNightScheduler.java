package com.uncr.studioapp.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MidNightScheduler {
    @Scheduled(cron = "2 0 0 * * *")
    public void channelInfoUpdate()  {

    }
}
