package com.cj.arcard.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Card extends BmobObject {
    private MyUser sender;
    private CardTemplate template;
    private MyUser myUser;

    @Override
    public String toString() {
        return "Card{" +
                ", sender='" + sender + '\'' +
                ", template=" + template +
                ", myUser=" + myUser +
                '}';
    }


    public MyUser getSender() {
        return sender;
    }

    public void setSender(MyUser sender) {
        this.sender = sender;
    }

    public CardTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CardTemplate template) {
        this.template = template;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
