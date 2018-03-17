package com.cheese.slackbot.slack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class SlackMessageDto {

    @Getter
    @NoArgsConstructor
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
    public static class MessageButtons {
        private String text;
        private List<MessageButtonAttachment> attachments;

        @Builder
        public MessageButtons(String text, List<MessageButtonAttachment> attachments) {
            this.text = text;
            this.attachments = attachments;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class MessageButtonAttachment {
        private String text;
        private String fallback;
        private String callback_id;
        private String color;
        private String attachment_type;
        private List<Action> actions;

        @Builder
        public MessageButtonAttachment(String text, String fallback, String callback_id, String color, String attachment_type, List<Action> actions) {
            this.text = text;
            this.fallback = fallback;
            this.callback_id = callback_id;
            this.color = color;
            this.attachment_type = attachment_type;
            this.actions = actions;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Action {
        private String name;
        private String text;
        private String type;
        private String value;
        private Confirm confirm;

        @Builder
        public Action(String name, String text, String type, String value, Confirm confirm) {
            this.name = name;
            this.text = text;
            this.type = type;
            this.value = value;
            this.confirm = confirm;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Confirm {
        private String title;
        private String text;
        private String ok_text;
        private String dismiss_text;

        @Builder
        public Confirm(String title, String text, String ok_text, String dismiss_text) {
            this.title = title;
            this.text = text;
            this.ok_text = ok_text;
            this.dismiss_text = dismiss_text;
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

        @Builder
        public Field(String title) {
            this.title = title;
        }
    }


}
