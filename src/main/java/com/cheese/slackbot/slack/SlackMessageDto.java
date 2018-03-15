package com.cheese.slackbot.slack;

import lombok.Builder;
import lombok.Getter;

public class SlackMessageDto {

    @Getter
    public static class Basic {
        private String text;

        @Builder
        public Basic(String text) {
            this.text = text;
        }
    }
}
