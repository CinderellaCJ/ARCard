package com.cj.arcard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cj.arcard.bean.Card;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/20.
 */

public class CardListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Card> mCardArrayList;

    public CardListAdapter(Context context, ArrayList<Card> cardArrayList) {
        mContext = context;
        mCardArrayList = cardArrayList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
