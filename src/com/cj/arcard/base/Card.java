package com.cj.arcard.base;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Card extends BmobObject {
    private String objectId;
    private String sender;

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
