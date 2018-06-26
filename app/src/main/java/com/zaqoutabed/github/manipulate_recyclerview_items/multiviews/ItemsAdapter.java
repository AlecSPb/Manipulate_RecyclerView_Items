package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items.IItem;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<IItem> itemList;

    public ItemsAdapter(List<IItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType){
            case R.layout.item_image_post:
                return  new ImageItemHolder(view);
            case R.layout.item_text_post:
                return new TextItemHolder(view);
            case R.layout.item_video_post:
                return new VideoItemHolder(view);
            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IItem item = itemList.get(position);
        item.bindViews(holder);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        IItem iItem = itemList.get(position);
        return iItem.getType();
    }

    public class ImageItemHolder extends RecyclerView.ViewHolder{
        public ImageView user_profile_image_view;
        public TextView user_name_text_view;
        public TextView post_text_view;
        public ImageView post_image_view;

        ImageItemHolder(View itemView) {
            super(itemView);
            user_profile_image_view = itemView.findViewById(R.id.user_profile_image_view);
            user_name_text_view = itemView.findViewById(R.id.user_name_text_view);
            post_text_view = itemView.findViewById(R.id.post_text_view);
            post_image_view = itemView.findViewById(R.id.post_image_view);
        }
    }
    public class TextItemHolder extends RecyclerView.ViewHolder{
        public ImageView user_profile_image_view;
        public TextView user_name_text_view;
        public TextView post_text_view;
        TextItemHolder(View itemView) {
            super(itemView);
            user_profile_image_view = itemView.findViewById(R.id.user_profile_image_view);
            user_name_text_view = itemView.findViewById(R.id.user_name_text_view);
            post_text_view = itemView.findViewById(R.id.post_text_view);
        }
    }
    public class VideoItemHolder extends RecyclerView.ViewHolder{
        public ImageView user_profile_image_view;
        public TextView user_name_text_view;
        public TextView post_text_view;
        public VideoView post_video_view;

        VideoItemHolder(View itemView) {
            super(itemView);
            user_profile_image_view = itemView.findViewById(R.id.user_profile_image_view);
            user_name_text_view = itemView.findViewById(R.id.user_name_text_view);
            post_text_view = itemView.findViewById(R.id.post_text_view);
            post_video_view = itemView.findViewById(R.id.post_video_view);
        }
    }
}
