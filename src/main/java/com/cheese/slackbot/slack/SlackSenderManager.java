package com.cheese.slackbot.slack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SlackSenderManager {

    private final RestTemplate restTemplate;

    @Autowired
    public SlackSenderManager(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean send(SlackTargetEnum target, SlackMessageDto.Basic dto) {
        try {
            restTemplate.postForEntity(target.getWebHookUrl(), dto, String.class);
            return true;
        } catch (Exception e) {
            log.error("Occur Exception: {}", e);
            return false;
        }

    }

    // TODO: 2018. 3. 16. 중복 코드 제거 -yun
    public boolean send(SlackTargetEnum target, SlackMessageDto.Attachments dto) {
        try {
            restTemplate.postForEntity(target.getWebHookUrl(), dto, String.class);
            return true;
        } catch (Exception e) {
            log.error("Occur Exception: {}", e);
            return false;
        }

    }

}
