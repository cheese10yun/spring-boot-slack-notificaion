package com.cheese.slackbot.slack;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class SlackSenderManager {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public void send(SlackTarget target, Object object) {
        restTemplate.postForEntity(target.getWebHookUrl(), writeValueAsString(object), String.class);
    }

    private String writeValueAsString(Object obj) {
        try {
            objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Occur JsonProcessingException: {}", e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
