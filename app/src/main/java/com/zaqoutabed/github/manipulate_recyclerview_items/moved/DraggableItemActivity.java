package com.zaqoutabed.github.manipulate_recyclerview_items.moved;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.ArrayList;
import java.util.List;

public class DraggableItemActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragable_item);

        getSupportActionBar().setTitle("Draggable Items");
        RecyclerView rv = findViewById(R.id.rv);
        itemList = new ArrayList<>();
        for (int i =0; i < 20; i++){
            Item item = new Item();
            item.text = i + item.text;
            this.itemList.add(item);
        }
        adapter = new ItemAdapter(itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN,0) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {

            }
        });

        itemTouchHelper.attachToRecyclerView(rv);
    }
    private void moveItem(int oldPos, int newPos) {
        Item item = itemList.get(oldPos);
        itemList.remove(oldPos);
        itemList.add(newPos, item);
        adapter.notifyItemMoved(oldPos, newPos);
    }
}