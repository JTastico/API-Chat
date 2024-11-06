package com.example.chat.controller;


import com.example.chat.model.ChatGptRequest;
import com.example.chat.model.ChatGptResponse;
import com.example.chat.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/generate")
    public ChatGptResponse generateText(@RequestBody ChatGptRequest request) {
        return chatGptService.getResponseFromChatGpt(request);
    }
}
