package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Card extends BmobObject {
    private String sender;




    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
