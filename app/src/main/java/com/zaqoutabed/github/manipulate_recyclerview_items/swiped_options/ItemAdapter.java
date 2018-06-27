package com.zaqoutabed.github.manipulate_recyclerview_items.swiped_options;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<IItem> itemList;
    public int DELETE_OPTION = 0, EDIT_OPTION = 1;
    ItemAdapter(List<IItem> itemList) {
        this.itemList = itemList;
    }
    private OnOptionClickListener onOptionClickListener;
    public interface OnOptionClickListener{
        void onOptionClicked(int position, int option);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType){
            case R.layout.swiped_main_item:
                return new MainItemHolder(view);
            case R.layout.swiped_options_item:
                return new OptionItemHolder(view);
            default: return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       IItem item = itemList.get(position);
       item.bindViews(holder);
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MainItemHolder extends RecyclerView.ViewHolder{
        TextView textView;
        MainItemHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    public class OptionItemHolder extends RecyclerView.ViewHolder{
        ImageView delete_image_view, edit_image_view;
        public OptionItemHolder(View itemView) {
            super(itemView);
            delete_image_view = itemView.findViewById(R.id.delete_image_view);
            edit_image_view = itemView.findViewById(R.id.edit_image_view);

            delete_image_view.setOnClickListener(v->{
                if (onOptionClickListener != null){
                    onOptionClickListener.onOptionClicked(this.getAdapterPosition(), DELETE_OPTION);
                }
            });
            edit_image_view.setOnClickListener(v->{
                if (onOptionClickListener != null){
                    onOptionClickListener.onOptionClicked(this.getAdapterPosition(), EDIT_OPTION);
                }
            });
        }
    }

    public void setOnOptionClickListener(OnOptionClickListener onOptionClickListener) {
        this.onOptionClickListener = onOptionClickListener;
    }
}
