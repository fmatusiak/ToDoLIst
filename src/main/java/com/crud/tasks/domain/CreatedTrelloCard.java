package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;
}
