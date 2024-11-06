package com.example.chat.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRequest {
    private String model = "text-davinci-003"; // o el modelo que desees usar
    private String prompt;
    private int maxTokens = 100;
    private double temperature = 0.7;
}
