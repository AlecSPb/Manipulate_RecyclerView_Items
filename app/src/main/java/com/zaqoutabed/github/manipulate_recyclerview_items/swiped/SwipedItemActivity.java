package com.zaqoutabed.github.manipulate_recyclerview_items.swiped;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.ArrayList;
import java.util.List;

public class SwipedItemActivity extends AppCompatActivity {
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiped_item);
        getSupportActionBar().setTitle("swipe Items left|right");
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


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                if (direction == ItemTouchHelper.LEFT){
                    Toast.makeText(SwipedItemActivity.this, "item go left", Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(SwipedItemActivity.this).create();
                    alertDialog.setTitle("Delete Item");
                    alertDialog.setMessage("Are you sure ...");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "yes",
                            (dialog, which) -> {
                                itemList.remove(viewHolder.getAdapterPosition());
                                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "no", ((dialog, which) ->{
                        dialog.dismiss();
                        adapter.notifyDataSetChanged();
                    }));
                    alertDialog.show();
                }else {
                    Toast.makeText(SwipedItemActivity.this, "item go right", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }

            }
        });

        itemTouchHelper.attachToRecyclerView(rv);
    }
}
