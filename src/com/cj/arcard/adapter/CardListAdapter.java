package com.cj.arcard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cj.arcard.R;
import com.cj.arcard.bean.CardInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/20.
 */

public class CardListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<CardInfo> mCardArrayList;

    public CardListAdapter(Context context, ArrayList<CardInfo> cardArrayList) {
        mContext = context;
        mCardArrayList = cardArrayList;
    }

    @Override
    public int getCount() {
        return mCardArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_card_list, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        CardInfo cardInfo = mCardArrayList.get(position);
        viewHolder.cardName.setText(cardInfo.getCardName());
        viewHolder.cardDescribe.setText(cardInfo.getCardDescribe());
        Glide.with(mContext).load(cardInfo.getCardPictureUrl()).into(viewHolder.cardImg);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.card_name)
        TextView cardName;
        @BindView(R.id.card_img)
        ImageView cardImg;
        @BindView(R.id.card_describe)
        TextView cardDescribe;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
