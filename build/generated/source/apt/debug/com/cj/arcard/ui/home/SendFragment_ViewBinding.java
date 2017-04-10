// Generated code from Butter Knife. Do not modify!
package com.cj.arcard.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hyphenate.chatuidemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SendFragment_ViewBinding<T extends SendFragment> implements Unbinder {
  protected T target;

  @UiThread
  public SendFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.mCardListView = Utils.findRequiredViewAsType(source, R.id.card_listView, "field 'mCardListView'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mCardListView = null;

    this.target = null;
  }
}
