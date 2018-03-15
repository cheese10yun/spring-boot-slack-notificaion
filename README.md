
# Slack Bot

## Basic Message
### Cul
```cul
curl -X GET \
  'http://localhost:8080/bot/basic?text=%EC%9D%BC%EB%8B%A8%ED%85%8C%EC%8A%A4' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 1e844242-4c69-eb63-9f80-3e7665825e5b'
```

### Basic Image
![](https://i.imgur.com/vo8xT1W.png)

## Attachments Message
### Cul
```cul
curl -X POST \
  http://localhost:8080/bot/attachment \
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

### Basic Image
![](https://i.imgur.com/5C2MmDG.png)

## Message-Buttons
### Cul
```cul
curl -X POST \
  http://localhost:8080/bot/button \
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

### Basic Image
![](https://i.imgur.com/7WZg910.png)

