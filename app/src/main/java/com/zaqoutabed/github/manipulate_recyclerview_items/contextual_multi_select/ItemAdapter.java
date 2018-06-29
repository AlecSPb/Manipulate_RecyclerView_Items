package com.zaqoutabed.github.manipulate_recyclerview_items.contextual_multi_select;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder>{

    private List<Item> itemList;
    private List<Item> selectedItems;
    private AppCompatActivity appCompatActivity;
    private boolean isActionMode = false;
    ItemAdapter(List<Item> itemList, AppCompatActivity appCompatActivity) {
        this.itemList = itemList;
        this.appCompatActivity = appCompatActivity;
        selectedItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contextual_checkbox_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.textView.setText(itemList.get(position).text);
        if (isActionMode){
            holder.item_check_box.setVisibility(View.VISIBLE);
            holder.item_check_box.setChecked(itemList.get(position).checked);
            holder.item_check_box.setOnCheckedChangeListener((buttonView, isChecked) -> {
                itemList.get(position).checked = isChecked;
                if (onItemChecked != null)
                    onItemChecked.onItemChecked(isChecked, position, itemList.get(position));
            });

        }else {
            holder.item_check_box.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox item_check_box;
        CardView card_view;
        ItemHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            item_check_box = itemView.findViewById(R.id.item_check_box);
            card_view = itemView.findViewById(R.id.card_view);
            card_view.setOnLongClickListener((ContextualActivity) appCompatActivity);
            ((ContextualActivity)appCompatActivity).setOnContextualModeListener(isIn -> {
                isActionMode = isIn;
            });

        }
    }
    private OnItemChecked onItemChecked;

    public void setOnItemChecked(OnItemChecked onItemChecked) {
        this.onItemChecked = onItemChecked;
    }
}
