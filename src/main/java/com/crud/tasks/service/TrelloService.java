package com.crud.tasks.service;

import com.crud.tasks.com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.dto.CreatedTrelloCardDto;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card";

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto createdTrelloCardDto = trelloClient.createNewCard(trelloCardDto);

        Optional.ofNullable(createdTrelloCardDto).ifPresent(createdTrelloCardDto1 -> simpleEmailService.send(new Mail(adminConfig.getAdminMail(), "", SUBJECT,
                "New card: " + trelloCardDto.getName() + " has been created on your Trello account")));
        return createdTrelloCardDto;
    }
}
