package com.zte.topsky.message.bean;

/**
 * Created by NobShiny
 * on 2016/10/8 16:12.
 */

public class Messages {
    public String messageTitle;
    public String messageContent;
    public boolean isRead;

    public Messages(String messageTitle, String messageContent, boolean isRead) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.isRead = isRead;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
