package com.cheese.slackbot.slack;

import lombok.Getter;

@Getter
public enum SlackTargetEnum {

    CH_BOT("https://hooks.slack.com/services/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", "bot");

    private final String webHookUrl;
    private final String channel;


    SlackTargetEnum(String webHookUrl, String channel) {
        this.webHookUrl = webHookUrl;
        this.channel = channel;
    }
}
