package com.cheese.slackbot.controller;


import com.cheese.slackbot.slack.SlackMessageDto;
import com.cheese.slackbot.slack.SlackSenderManager;
import com.cheese.slackbot.slack.SlackTargetEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("bot")
@Slf4j
public class BotController {

    @Autowired
    private SlackSenderManager slackSenderManager;

    @RequestMapping(value = "basic", method = POST)
    public ResponseEntity basic(@RequestBody SlackMessageDto.Basic dto) {
        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, dto));
    }

    @RequestMapping(value = "attachment", method = POST)
    public ResponseEntity attachment(@RequestBody SlackMessageDto.Attachments dto) {
        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, dto));
    }

    @RequestMapping(value = "button", method = POST)
    public ResponseEntity button(@RequestBody SlackMessageDto.MessageButtons dto) {
        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, dto));
    }


}
