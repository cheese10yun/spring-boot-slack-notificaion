package com.cheese.slackbot.controller;


import com.cheese.slackbot.slack.SlackMessageDto;
import com.cheese.slackbot.slack.SlackSenderManager;
import com.cheese.slackbot.slack.SlackTarget;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("slack")
@AllArgsConstructor
@Slf4j
public class SlackController {

    private SlackSenderManager slackSenderManager;

    @RequestMapping(value = "basic", method = POST)
    public void basic(@RequestBody SlackMessageDto.Basic dto) {
        slackSenderManager.send(SlackTarget.CH_BOT, dto);
    }

    @RequestMapping(value = "attachment", method = POST)
    public void attachment(@RequestBody SlackMessageDto.Attachments dto) {
        slackSenderManager.send(SlackTarget.CH_BOT, dto);
    }

    @RequestMapping(value = "button", method = POST)
    public void button(@RequestBody SlackMessageDto.MessageButtons dto) {
        slackSenderManager.send(SlackTarget.CH_BOT, dto);
    }


}
