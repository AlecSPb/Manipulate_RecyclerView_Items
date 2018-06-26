package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items;

import android.support.v7.widget.RecyclerView;

public interface IItem {
    int getType();
    void bindViews(RecyclerView.ViewHolder holder);
}
