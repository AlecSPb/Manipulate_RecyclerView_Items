package com.zaqoutabed.github.manipulate_recyclerview_items.swiped_options;

import android.support.v7.widget.RecyclerView;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

class MainItem implements IItem{
    String text = " Swipe Left to select option.....";

    @Override
    public int getType() {
        return R.layout.swiped_main_item;
    }

    @Override
    public void bindViews(RecyclerView.ViewHolder holder) {
        ItemAdapter.MainItemHolder mainItemHolder = (ItemAdapter.MainItemHolder)holder;
        mainItemHolder.textView.setText(this.text);
    }
}