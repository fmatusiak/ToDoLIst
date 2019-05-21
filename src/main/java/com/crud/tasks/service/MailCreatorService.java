package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.trello.config.AdminConfig;
import com.crud.tasks.trello.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye_message", "See you later");
        context.setVariable("company_name", companyConfig.getCompaName());
        context.setVariable("company_goal", companyConfig.getCompanyGoal());
        context.setVariable("company_email", companyConfig.getCompanyEmail());
        context.setVariable("company_phone", companyConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildNumberTasksMail() {
        List<Task> tasksList;
        tasksList = taskRepository.findAll();

        Context context = new Context();
        context.setVariable("tasks_url", "http://localhost:8080/crud");
        context.setVariable("number_tasks", taskRepository.count());
        context.setVariable("tasks_list", tasksList);
        context.setVariable("tasks_name_title", "Tasks title");
        return templateEngine.process("mail/number-tasks-mail", context);
    }


}

