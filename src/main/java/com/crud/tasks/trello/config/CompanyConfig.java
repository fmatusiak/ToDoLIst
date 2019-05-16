package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompanyConfig {

    @Value("${info.app.company.name}")
    private String compaName;

    @Value("${info.app.company.goal}")
    private String companyGoal;

    @Value("${info.app.company.email}")
    private String companyEmail;

    @Value("${info.app.company.phone}")
    private String companyPhone;

}
