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

import com.cj.arcard.R;
import com.cj.arcard.adapter.CardListAdapter;
import com.cj.arcard.bean.Card;
import com.cj.arcard.bean.CardInfo;
import com.cj.arcard.bean.CardTemplate;
import com.cj.arcard.bean.MyUser;
import com.cj.arcard.utils.LogUtil;
import com.cj.arcard.utils.ToastUtil;
import com.cj.arcard.utils.ToolbarCaptureActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Administrator on 2017/3/20.
 */

public class SendFragment extends Fragment {

    @BindView(R.id.card_listView)
    ListView mCardListView;
    private View mView;
    private ArrayList<CardInfo> mCardArrayList;
    private CardListAdapter mCardListAdapter;

    private ImageView scanImage;
    private MyUser currentUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_send, container, false);
        }
        ButterKnife.bind(this, mView);
        currentUser = BmobUser.getCurrentUser(MyUser.class);

        //listView设置headView
        View headView = inflater.inflate(R.layout.fragment_headview, null);

        scanImage = (ImageView) headView.findViewById(R.id.scan);
        scanImage.setOnClickListener(new scanListener());

        mCardArrayList = new ArrayList<>();

        initData();
        mCardListAdapter = new CardListAdapter(getActivity(),mCardArrayList);
        mCardListView.addHeaderView(headView);
        mCardListView.setAdapter(mCardListAdapter);
        return mView;
    }

    private void initData() {
        BmobQuery<Card> cardQuery = new BmobQuery<>();
        cardQuery.addWhereEqualTo("sender",currentUser);
        cardQuery.include("template");
        cardQuery.findObjects(new FindListener<Card>() {
            @Override
            public void done(List<Card> list, BmobException e) {
                if (e == null){
                   // LogUtil.d(list.toString());
                    for (Card cardList : list){
                        CardTemplate template = cardList.getTemplate();
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.setCardName(template.getCardName());
                        cardInfo.setCardDescribe(template.getCardDescribe());
                        cardInfo.setCardPictureUrl(template.getCardPicture().getUrl());
                        mCardArrayList.add(cardInfo);
                        mCardListAdapter.notifyDataSetChanged();
                    }
                }else {
                    LogUtil.d("查询失败："+e.getMessage() + e.getErrorCode());
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
            String scanId = result.getContents();

            BmobQuery<Card> query = new BmobQuery<>();
            query.include("template");
            query.getObject(scanId, new QueryListener<Card>() {
                @Override
                public void done(Card card, BmobException e) {
                    if (e == null){
                        LogUtil.d(card.getTemplate().getCardName());
                        //添加一条数据
                        CardTemplate template = card.getTemplate();
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.setCardName(template.getCardName());
                        cardInfo.setCardDescribe(template.getCardDescribe());
                        cardInfo.setCardPictureUrl(template.getCardPicture().getUrl());
                        mCardArrayList.add(0,cardInfo);
                        mCardListAdapter.notifyDataSetChanged();

                        //将当前用户插入到sender
                        card.setSender(currentUser);
                        card.update(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {

                            }
                        });
                    }else {
                        LogUtil.d("失败："+e.getMessage() + e.getErrorCode());
                    }
                }
            });

        }
    }
}
