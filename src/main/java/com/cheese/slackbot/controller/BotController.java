package com.cheese.slackbot.controller;


import com.cheese.slackbot.slack.SlackMessageDto;
import com.cheese.slackbot.slack.SlackSenderManager;
import com.cheese.slackbot.slack.SlackTargetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("bot")
public class BotController {

    @Autowired
    private SlackSenderManager slackSenderManager;

    @RequestMapping(value = "basic", method = GET)
    public ResponseEntity basic(@RequestParam(value = "text") String text) {

        final SlackMessageDto.Basic basic = SlackMessageDto.Basic.builder()
                .text(text)
                .build();

        return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, basic));
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
