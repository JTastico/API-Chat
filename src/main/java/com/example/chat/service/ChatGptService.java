package com.example.chat.service;

import com.example.chat.config.OpenAiConfig;
import com.example.chat.model.ChatGptRequest;
import com.example.chat.model.ChatGptResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class ChatGptService {

    private final OpenAiConfig openAiConfig;

    // Inyectamos OpenAiConfig en el constructor
    public ChatGptService(OpenAiConfig openAiConfig) {
        this.openAiConfig = openAiConfig;
    }

    public ChatGptResponse getResponseFromChatGpt(ChatGptRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        // Configuración de encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openAiConfig.getKey());

        // Crear entidad HTTP con el cuerpo de la solicitud y los encabezados
        HttpEntity<ChatGptRequest> entity = new HttpEntity<>(request, headers);

        // Llamada a la API de OpenAI
        ResponseEntity<ChatGptResponse> response = restTemplate.postForEntity(openAiConfig.getUrl(), entity, ChatGptResponse.class);
        return response.getBody();
    }
}
