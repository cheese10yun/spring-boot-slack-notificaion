package com.cheese.slackbot.slack;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SlackSenderManager {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public SlackSenderManager(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public boolean send(SlackTargetEnum target, Object object) {
        try {
            restTemplate.postForEntity(target.getWebHookUrl(), writeValueAsString(object), String.class);
            return true;
        } catch (Exception e) {
            log.error("Occur Exception: {}", e);
            return false;
        }
    }

    private String writeValueAsString(Object obj) {
        String json = null;
        try {
            objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Occur JsonProcessingException: {}", e);
        }
        return json;
    }

}
