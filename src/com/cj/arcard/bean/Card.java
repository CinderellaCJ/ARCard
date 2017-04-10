package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Card extends BmobObject {
    private String sender;
    private CardTemplate template;
    private String cardId;

    @Override
    public String toString() {
        return "Card{" +
                "sender='" + sender + '\'' +
                ", template=" + template +
                ", cardId='" + cardId + '\'' +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public CardTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CardTemplate template) {
        this.template = template;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
