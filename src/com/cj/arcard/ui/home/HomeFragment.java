package com.cj.arcard.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cj.arcard.utils.ToastUtil;
import com.hyphenate.chatuidemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/9.
 */

public class HomeFragment extends Fragment {

    final static String TAG_SEND = "rend";
    final static String TAG_RECEIVER = "receiver";

    @BindView(R.id.radio_send)
    RadioButton mRadioSend;
    @BindView(R.id.radio_receiver)
    RadioButton mRadioReceiver;
    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_home, container, false);
        }

        ButterKnife.bind(this, mView);
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_send:
                setFragmentSend(new SendFragment());
                break;
            case R.id.radio_receiver:
                setFragmentReceiver(new ReceiverFragment());
                break;
        }
        return mView;
    }

    @OnClick({R.id.radio_send, R.id.radio_receiver})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_send:
                setFragmentSend(new SendFragment());
                ToastUtil.showShort(getActivity(),"aaa");
                break;
            case R.id.radio_receiver:
                setFragmentReceiver(new ReceiverFragment());
                ToastUtil.showShort(getActivity(),"bbb");
                break;
        }
    }

    private void setFragmentSend(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout_frame, fragment, TAG_SEND);
        transaction.commit();
    }

    private void setFragmentReceiver(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout_frame, fragment, TAG_RECEIVER);
        transaction.commit();
    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<Fragment> fragments = getFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                if (fragment.getTag().equals(TAG_SEND)) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
                if (fragment.getTag().equals(TAG_RECEIVER)) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }*/
}
