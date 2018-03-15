package com.cheese.slackbot.slack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class SlackMessageDto {

    @Getter
    public static class Basic {
        private String text;

        @Builder
        public Basic(String text) {
            this.text = text;
        }
    }


    @Getter
    @NoArgsConstructor
    public static class Attachments {
        private List<Attachment> attachments;

        @Builder
        public Attachments(List<Attachment> attachments) {
            this.attachments = attachments;
        }
    }


    @Getter
    @NoArgsConstructor
    public static class Attachment {
        private String fallback;
        private String color;
        private String pretext;
        private String author_name;
        private String author_link;
        private String author_icon;
        private String title;
        private String title_link;
        private String text;
        private String image_url;
        private String thumb_url;
        private String footer;
        private String footer_icon;
        private Long ts;
        private List<Field> fields;

        @Builder
        public Attachment(String fallback, String color, String pretext, String author_name, String author_link, String author_icon, String title, String title_link, String text, String image_url, String thumb_url, String footer, String footer_icon, Long ts, List<Field> fields) {
            this.fallback = fallback;
            this.color = color;
            this.pretext = pretext;
            this.author_name = author_name;
            this.author_link = author_link;
            this.author_icon = author_icon;
            this.title = title;
            this.title_link = title_link;
            this.text = text;
            this.image_url = image_url;
            this.thumb_url = thumb_url;
            this.footer = footer;
            this.footer_icon = footer_icon;
            this.ts = ts;
            this.fields = fields;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Field {
        private String title;
        private String value;
//        private boolean short;

        @Builder
        public Field(String title) {
            this.title = title;
        }
    }


}
