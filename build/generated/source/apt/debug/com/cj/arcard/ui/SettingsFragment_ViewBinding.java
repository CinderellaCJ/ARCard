// Generated code from Butter Knife. Do not modify!
package com.cj.arcard.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.cj.arcard.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingsFragment_ViewBinding<T extends SettingsFragment> implements Unbinder {
  protected T target;

  private View view2131427598;

  @UiThread
  public SettingsFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.my_head_avatar, "field 'myHeadAvatar' and method 'onViewClicked'");
    target.myHeadAvatar = Utils.castView(view, R.id.my_head_avatar, "field 'myHeadAvatar'", ImageView.class);
    view2131427598 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.myHeadAvatar = null;

    view2131427598.setOnClickListener(null);
    view2131427598 = null;

    this.target = null;
  }
}
