package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by chenjing on 2017/4/6.
 */

public class CardTemplate extends BmobObject{
    private String cardName;

    @Override
    public String toString() {
        return "CardTemplate{" +
                "cardName='" + cardName + '\'' +
                '}';
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
