package com.cj.arcard.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.cj.arcard.adapter.CardListAdapter;
import com.cj.arcard.bean.Card;
import com.cj.arcard.utils.LogUtil;
import com.cj.arcard.utils.ToastUtil;
import com.cj.arcard.utils.ToolbarCaptureActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hyphenate.chatuidemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/3/20.
 */

public class SendFragment extends Fragment {

    @BindView(R.id.card_listView)
    ListView mCardListView;
    private View mView;
    private ArrayList<Card> mCardArrayList;
    private CardListAdapter mCardListAdapter;

    private ImageView scanImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_send, container, false);
        }
        ButterKnife.bind(this, mView);

        //listView设置headView
        View headView = inflater.inflate(R.layout.fragment_headview, null);
        mCardListView.addHeaderView(headView);
        scanImage = (ImageView) headView.findViewById(R.id.scan);
        scanImage.setOnClickListener(new scanListener());

        mCardArrayList = new ArrayList<>();
        mCardListAdapter = new CardListAdapter(getActivity(),mCardArrayList);
        mCardListView.setAdapter(mCardListAdapter);
        LogUtil.d("aaaaaaaaaaaaaa");
        initData();
        return mView;
    }

    private void initData() {
        Card card = new Card();
        card.setCardId("1");
        card.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null){
                    ToastUtil.showShort(getActivity(),"添加数据成功");
                }else {
                    LogUtil.d("失败："+e.getMessage()+","+e.getErrorCode());
                }

            }
        });

        BmobQuery<Card> query = new BmobQuery<Card>();
        query.getObject("bbe67b6a90", new QueryListener<Card>() {
            @Override
            public void done(Card card, BmobException e) {
                if (e == null){

                    LogUtil.d(card.getCreatedAt());
                    LogUtil.d(card.getCardId());
                }else {
                    LogUtil.d("失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    /**
     * 扫描二维码
     */
    private class scanListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            new IntentIntegrator(getActivity()).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result.getContents() == null) {
            ToastUtil.showShort(getActivity(), "您取消了扫描");
        } else {
            ToastUtil.showShort(getActivity(),result.getContents());
            LogUtil.d("111111111111111111111111" + result.getContents());

        }
    }
}
