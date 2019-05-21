package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    // @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 12 * * *")
    public void sendInformationNumberTasksEmail() {
        simpleEmailService.sendNumberTasksMail(new Mail(adminConfig.getAdminMail(), "", "Daily task report", ""));
    }
}
