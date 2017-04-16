// Generated code from Butter Knife. Do not modify!
package com.cj.arcard.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.cj.arcard.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CardListAdapter$ViewHolder_ViewBinding<T extends CardListAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public CardListAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.cardName = Utils.findRequiredViewAsType(source, R.id.card_name, "field 'cardName'", TextView.class);
    target.cardImg = Utils.findRequiredViewAsType(source, R.id.card_img, "field 'cardImg'", ImageView.class);
    target.cardDescribe = Utils.findRequiredViewAsType(source, R.id.card_describe, "field 'cardDescribe'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.cardName = null;
    target.cardImg = null;
    target.cardDescribe = null;

    this.target = null;
  }
}
