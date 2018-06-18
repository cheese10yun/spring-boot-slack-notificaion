
# Slack Notification


## 프로젝트 설명

**[프로젝트 소스](https://github.com/cheese10yun/slackbot)**

Spring boot 으로 초간단하게 Slack Message 보내기를 만들어 보는 프로젝트입니다.  현재는 별다른 기능은 없고 정말 단순하게 메세지 보내는 기능만 있습니다. [branch : release-1](https://github.com/cheese10yun/slackbot/tree/release-1)에 최대한 가져다 Copy & Paste 하기 쉽게? 만들었습니다. (~~조금이라도 도움이 되셨다면 start 좀...~~) [Slack Message](https://api.slack.com/docs/messages/builder) 에서 제공하는 3 가지 메세지를 보내 보겠습니다. 포스팅 하단에 Curl로 실제 메세지를 보내 볼 수 있습니다.

앞으로는 프로젝트 특정 시나리오에서 Exception 발생 했을 경우 Slack 으로 에러 메세지가 오게 설정하는 등 다양한 에러 메세지를 Slack 통해서 받아 볼 수 있게 할 예정입니다.


## Slack Web Hook 연동

![](https://i.imgur.com/MBhHN58.png)

Incoming WebHooks 작업이 완료 됬다고 가정하고 포스팅을 진행하겠습니다. 만약 작업이 완료 되지 않았다면 해당 앱을 설치하고 특정 채널에 알림이 가게 설정해주세요

## Slack Message 유형

크게 3 가지 유형이 있습니다. 이미지 형태와 컨트롤러에서 보내 볼 수 받아 볼 수 있는 Curl 하나하나 살펴보습니다.

### Basic

#### 이미지
![](https://i.imgur.com/W6Gg0eV.png)

```
curl -X POST \
  http://localhost:8080/bot/basic \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: db7316c5-3358-0ccc-4de4-03bd7dd307c4' \
  -d '{
	"text": "text"
}'
```

### Attachments

#### 이미지
![](https://i.imgur.com/Povsbzl.png)

#### Curl
```
curl -X POST \
  http://localhost:8080/bot/button \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 0b503f02-713c-afdc-8c8f-b007c7bfb882' \
  -d '{
    "text": "Would you like to play a game?",
    "attachments": [
        {
            "text": "Choose a game to play",
            "fallback": "You are unable to choose a game",
            "callback_id": "wopr_game",
            "color": "#3AA3E3",
            "attachment_type": "default",
            "actions": [
                {
                    "name": "game",
                    "text": "Chess",
                    "type": "button",
                    "value": "chess"
                },
                {
                    "name": "game",
                    "text": "Falken'\''s Maze",
                    "type": "button",
                    "value": "maze"
                },
                {
                    "name": "game",
                    "text": "Thermonuclear War",
                    "style": "danger",
                    "type": "button",
                    "value": "war",
                    "confirm": {
                        "title": "Are you sure?",
                        "text": "Wouldn'\''t you prefer a good game of chess?",
                        "ok_text": "Yes",
                        "dismiss_text": "No"
                    }
                }
            ]
        }
    ]
}'
```

### Message buttons

#### 이미지
![](https://i.imgur.com/GEAfeAJ.png)

#### Curl
```
curl -X POST \
  http://localhost:8080/bot/attachment \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 53d665f3-c1e7-064d-e957-525a703e3965' \
  -d '{
  "attachments": [
    {
      "fallback": "Required plain-text summary of the attachment.",
      "color": "#36a64f",
      "pretext": "Optional text that appears above the attachment block",
      "author_name": "Bobby Tables",
      "author_link": "http://flickr.com/bobby/",
      "author_icon": "http://flickr.com/icons/bobby.jpg",
      "title": "Slack API Documentation",
      "title_link": "https://api.slack.com/",
      "text": "Optional text that appears within the attachment",
      "fields": [
        {
          "title": "Priority",
          "value": "High"
        }
      ],
      "image_url": "http://my-website.com/path/to/image.jpg",
      "thumb_url": "http://example.com/path/to/thumb.png",
      "footer": "Slack API",
      "footer_icon": "https://platform.slack-edge.com/img/default_application_icon.png",
      "ts": 1
    }
  ]
}'
```

## Bot 만들기

### Web Hook 연결

```java
@Getter
public enum SlackTargetEnum {

    CH_BOT("발급받은 Web Hook URL", "채널 이름");

    private final String webHookUrl;
    private final String channel;


    SlackTargetEnum(String webHookUrl, String channel) {
        this.webHookUrl = webHookUrl;
        this.channel = channel;
    }
}
```

슬랙 Web Hook URL 을 입력해주세요

### DTO 만들기

Attachments JSON을 DTO로 만들어 보겠습니다.

```java
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
```

### Controller

```java
@RequestMapping(value = "attachment", method = POST)
public ResponseEntity attachment(@RequestBody SlackMessageDto.Attachments dto) {
    return ResponseEntity.ok(slackSenderManager.send(SlackTargetEnum.CH_BOT, dto));
}
```

### Slack Web Hook 보내기

```java
public boolean send(SlackTargetEnum target, Object object) {
    try {
        restTemplate.postForEntity(target.getWebHookUrl(), writeValueAsString(object), String.class);
        return true;
    } catch (Exception e) {
        log.error("Occur Exception: {}", e);
        return false;
    }
}
```
**restTemplate 을 이용해서 컨트롤러에서 받은 DTO를 JSON으로 보내주고 있습니다.**


## 마무리

**포스팅 내용을 대충 보시고 실제 코드를 보시는 게 더 빨리 이해하실 수 있을 거 같습니다.** 최대한 간단하게 만들어서 처음 슬랙 알림을 만드시는 분이 편하게 가져다 쓰기 쉽게 만들어 봤습니다. 해당 프로젝트는 에러 발생시 Slack으로 메세징 받게 이어 나갈거 같습니다. Slack-Notificaion 프로젝트로 다시 찾아 뵙겠습니다.

