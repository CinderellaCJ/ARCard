package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by chenjing on 2017/4/6.
 */

public class CardTemplate extends BmobObject{
    private String cardName;
    private String cardDescribe;
    private BmobFile cardPicture;

    @Override
    public String toString() {
        return "CardTemplate{" +
                "cardName='" + cardName + '\'' +
                ", cardDescribe='" + cardDescribe + '\'' +
                ", cardPicture='" + cardPicture + '\'' +
                '}';
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescribe() {
        return cardDescribe;
    }

    public void setCardDescribe(String cardDescribe) {
        this.cardDescribe = cardDescribe;
    }

    public BmobFile getCardPicture() {
        return cardPicture;
    }

    public void setCardPicture(BmobFile cardPicture) {
        this.cardPicture = cardPicture;
    }
}
