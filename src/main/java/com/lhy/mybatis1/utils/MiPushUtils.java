package com.lhy.mybatis1.utils;

import com.xiaomi.xmpush.server.Message;

public class MiPushUtils {

    private Message buildMessage() throws Exception {
        String PACKAGENAME = "lhy.jelly";
        String messagePayload = "This is a message";
        Message message = new Message.Builder()
                .title("title")
                .description("test")
                .payload(messagePayload)
                .restrictedPackageName(PACKAGENAME)
                .passThrough(1)  // 消息使用透传方式
                .notifyType(1)   // 使用默认提示音提示
                .build();
        return message;
    }
}
