package com.example.chat.service;


import com.example.chat.model.ChatGptRequest;
import com.example.chat.model.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class ChatGptService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public ChatGptResponse getResponseFromChatGpt(@RequestBody ChatGptRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<ChatGptRequest> entity = new HttpEntity<>(request, headers);
        
        ResponseEntity<ChatGptResponse> response = restTemplate.postForEntity(apiUrl, entity, ChatGptResponse.class);
        return response.getBody();
    }
}
