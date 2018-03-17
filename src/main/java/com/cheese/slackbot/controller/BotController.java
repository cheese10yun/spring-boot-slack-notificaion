package com.cheese.slackbot.controller;


import com.cheese.slackbot.slack.SlackMessageDto;
import com.cheese.slackbot.slack.SlackSenderManager;
import com.cheese.slackbot.slack.SlackTargetEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("bot")
@Slf4j
public class BotController {

    @Autowired
    private SlackSenderManager slackSenderManager;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "basic", method = GET)
    public ResponseEntity basic(@RequestParam(value = "text") String text) {

        final SlackMessageDto.Basic basic = SlackMessageDto.Basic.builder()
                .text(text)
                .build();

        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, writeValueAsString(basic)));
    }

    @RequestMapping(value = "attachment", method = POST)
    public ResponseEntity attachment(@RequestBody SlackMessageDto.Attachments dto) {
        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, writeValueAsString(dto)));
    }

    @RequestMapping(value = "button", method = POST)
    public ResponseEntity button(@RequestBody SlackMessageDto.MessageButtons dto) {
        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, writeValueAsString(dto)));
    }

    private String writeValueAsString(Object obj) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Occur JsonProcessingException: {}", e);
        }
        return json;
    }


}
