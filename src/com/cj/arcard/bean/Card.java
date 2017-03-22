package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Card extends BmobObject {
    private String sender;
    private String template;
    private String cardId;




    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
