// Generated code from Butter Knife. Do not modify!
package com.cj.arcard.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hyphenate.chatuidemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131427658;

  private View view2131427659;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.radio_send, "field 'mRadioSend' and method 'onClick'");
    target.mRadioSend = Utils.castView(view, R.id.radio_send, "field 'mRadioSend'", RadioButton.class);
    view2131427658 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_receiver, "field 'mRadioReceiver' and method 'onClick'");
    target.mRadioReceiver = Utils.castView(view, R.id.radio_receiver, "field 'mRadioReceiver'", RadioButton.class);
    view2131427659 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mRadioGroup = Utils.findRequiredViewAsType(source, R.id.radio_group, "field 'mRadioGroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mRadioSend = null;
    target.mRadioReceiver = null;
    target.mRadioGroup = null;

    view2131427658.setOnClickListener(null);
    view2131427658 = null;
    view2131427659.setOnClickListener(null);
    view2131427659 = null;

    this.target = null;
  }
}
