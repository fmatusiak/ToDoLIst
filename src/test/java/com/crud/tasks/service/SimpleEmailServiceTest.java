package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "", "Test", "Test Message");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(mail.getMessage());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setTo(mail.getMailTo());

        //When
        simpleEmailService.send(mail);

        //Then
        // Mockito.verify(javaMailSender, Mockito.times(1)).send(simpleMailMessage);
    }



}