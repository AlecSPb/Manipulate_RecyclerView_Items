package com.zaqoutabed.github.manipulate_recyclerview_items.swiped_options;

import android.support.v7.widget.RecyclerView;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

public class OptionItem implements IItem {
    @Override
    public int getType() {
        return R.layout.swiped_options_item;
    }

    @Override
    public void bindViews(RecyclerView.ViewHolder holder) {
    }
}
