# Slack Notification

Spring boot으로 초간단하게 Slack Message 보내기를 만들어 보는 프로젝트입니다. [Slack Message](https://api.slack.com/docs/messages/builder) 에서 제공하는 3가지 메시지를 보내 보겠습니다. 포스팅 하단에 Curl로 실제 메시지를 보내 볼 수 있습니다.

# Basic Message
## Curl
```curl
curl -X POST \
  http://localhost:8080/slack/basic \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c1f6c1bf-3be6-81f0-af7f-c407997ce8f8' \
  -d '{
  "text": "기본메시지"
}'
```

## Basic Image
![](https://i.imgur.com/vo8xT1W.png)

# Attachments Message
## Curl
```curl
curl -X POST \
  http://localhost:8080/slack/attachment \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 410798ba-9355-8171-6439-b7de11052ca0' \
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

## Basic Image
![](https://i.imgur.com/5C2MmDG.png)

# Message-Buttons
## Curl
```curl
curl -X POST \
  http://localhost:8080/slack/button \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 558557b0-f75e-56c1-6b84-22655bc19ba1' \
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

## Basic Image
![](https://i.imgur.com/7WZg910.png)

