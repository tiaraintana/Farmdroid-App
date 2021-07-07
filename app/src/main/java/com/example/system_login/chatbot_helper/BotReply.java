package com.example.system_login.chatbot_helper;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;

public interface BotReply {
    void callback(DetectIntentResponse returnResponse);
}
