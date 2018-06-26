package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items;

import android.support.v7.widget.RecyclerView;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.ItemsAdapter;

public class ImagePostItem extends PostItem {

    private int imageSrc;
    private String textPost;

    public ImagePostItem(String userName, int userImageRcs, int imageSrc, String textPost) {
        super(userName, userImageRcs);
        this.imageSrc = imageSrc;
        this.textPost = textPost;
    }

    @Override
    public int getType() {
        return R.layout.item_image_post;
    }

    @Override
    public void bindViews(RecyclerView.ViewHolder holder) {
        ItemsAdapter.ImageItemHolder itemHolder = (ItemsAdapter.ImageItemHolder) holder;
        itemHolder.user_profile_image_view.setImageResource(this.getUserImageRcs());
        itemHolder.user_name_text_view.setText(this.getUserName());
        itemHolder.post_text_view.setText(this.textPost);
        itemHolder.post_image_view.setImageResource(this.imageSrc);
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }
}
