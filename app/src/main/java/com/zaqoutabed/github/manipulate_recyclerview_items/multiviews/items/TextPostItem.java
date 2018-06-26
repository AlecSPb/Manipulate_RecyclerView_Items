package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items;

import android.support.v7.widget.RecyclerView;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.ItemsAdapter;

public class TextPostItem extends PostItem {
    private String textPost;

    public TextPostItem(String userName, int userImageRcs, String textPost) {
        super(userName, userImageRcs);
        this.textPost = textPost;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    @Override
    public int getType() {
        return R.layout.item_text_post;
    }

    @Override
    public void bindViews(RecyclerView.ViewHolder holder) {
        ItemsAdapter.TextItemHolder itemHolder = (ItemsAdapter.TextItemHolder) holder;
        itemHolder.user_profile_image_view.setImageResource(this.getUserImageRcs());
        itemHolder.user_name_text_view.setText(this.getUserName());
        itemHolder.post_text_view.setText(this.textPost);
    }
}
