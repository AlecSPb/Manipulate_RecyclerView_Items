package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.MediaController;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.ItemsAdapter;

public class VideoPostItem extends PostItem {

    private String videoUrl;
    private String textPost;

    public VideoPostItem(String userName, int userImageRcs, String videoUrl, String textPost) {
        super(userName, userImageRcs);
        this.videoUrl = videoUrl;
        this.textPost = textPost;
    }

    @Override
    public int getType() {
        return R.layout.item_video_post;
    }

    @Override
    public void bindViews(RecyclerView.ViewHolder holder) {
        ItemsAdapter.VideoItemHolder itemHolder = (ItemsAdapter.VideoItemHolder) holder;
        itemHolder.user_profile_image_view.setImageResource(this.getUserImageRcs());
        itemHolder.user_name_text_view.setText(this.getUserName());
        itemHolder.post_text_view.setText(this.textPost);

        MediaController mediaController = new MediaController(itemHolder.post_video_view.getContext());
        Uri uri = Uri.parse(this.videoUrl);
        itemHolder.post_video_view.setVideoURI(uri);
        itemHolder.post_video_view.setMediaController(mediaController);
        mediaController.setAnchorView(itemHolder.post_video_view);
        itemHolder.post_video_view.setOnClickListener(v->{
            if (itemHolder.post_video_view.isPlaying())
                itemHolder.post_video_view.stopPlayback();
            else
                itemHolder.post_video_view.start();
        });
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }
}
