package com.example.chat.model;

import lombok.Data;

import java.util.List;

@Data
public class ChatGptResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private String text;
    }
}
