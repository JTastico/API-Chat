package com.example.chat.controller;

import com.example.chat.request.SearchRequest;
import com.example.chat.service.ChatGPTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatGPTController {

    private static final Logger log = LoggerFactory.getLogger(ChatGPTController.class);

    @Autowired
    private ChatGPTService chatGPTService;

@PostMapping("/search")
public String search(@RequestBody SearchRequest searchRequest){
    log.info("Received search request with query: {}", searchRequest.getQuery());
    return chatGPTService.getResponse(searchRequest.getQuery());
}
}