package com.example.chat.response;

import com.example.chat.model.ChatGPTChoice;
import lombok.Data;

import java.util.List;

@Data
public class ChatGPTResponse {

    private List<ChatGPTChoice> choices;

}
