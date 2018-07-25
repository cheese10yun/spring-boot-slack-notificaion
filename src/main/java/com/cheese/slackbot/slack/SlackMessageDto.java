package com.cheese.slackbot.slack;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("callback_id")
        private String callbackId;
        private String color;
        @JsonProperty("attachment_type")
        private String attachmentType;
        private List<Action> actions;

        @Builder
        public MessageButtonAttachment(String text, String fallback, String callbackId, String color, String attachmentType, List<Action> actions) {
            this.text = text;
            this.fallback = fallback;
            this.callbackId = callbackId;
            this.color = color;
            this.attachmentType = attachmentType;
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
        @JsonProperty("ok_text")
        private String okText;
        @JsonProperty("dismiss_text")
        private String dismissText;

        @Builder
        public Confirm(String title, String text, String okText, String dismissText) {
            this.title = title;
            this.text = text;
            this.okText = okText;
            this.dismissText = dismissText;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Attachment {
        private String fallback;
        private String color;
        private String pretext;
        @JsonProperty("author_name")
        private String authorName;
        @JsonProperty("author_link")
        private String author_link;
        @JsonProperty("author_icon")
        private String authorIcon;
        private String title;
        @JsonProperty("title_link")
        private String titleLink;
        private String text;
        @JsonProperty("image_url")
        private String imageUrl;
        @JsonProperty("thumb_url")
        private String thumbUrl;
        private String footer;
        @JsonProperty("footer_icon")
        private String footerIcon;
        private Long ts;
        private List<Field> fields;

        @Builder
        public Attachment(String fallback, String color, String pretext, String authorName, String author_link, String authorIcon, String title, String titleLink, String text, String imageUrl, String thumbUrl, String footer, String footerIcon, Long ts, List<Field> fields) {
            this.fallback = fallback;
            this.color = color;
            this.pretext = pretext;
            this.authorName = authorName;
            this.author_link = author_link;
            this.authorIcon = authorIcon;
            this.title = title;
            this.titleLink = titleLink;
            this.text = text;
            this.imageUrl = imageUrl;
            this.thumbUrl = thumbUrl;
            this.footer = footer;
            this.footerIcon = footerIcon;
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
