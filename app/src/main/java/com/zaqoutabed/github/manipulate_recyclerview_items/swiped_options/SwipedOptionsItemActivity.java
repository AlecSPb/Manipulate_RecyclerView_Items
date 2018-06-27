package com.zaqoutabed.github.manipulate_recyclerview_items.swiped_options;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.ArrayList;
import java.util.List;

public class SwipedOptionsItemActivity extends AppCompatActivity {
    private ItemAdapter adapter;
    private List<IItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiped_options_item);
        getSupportActionBar().setTitle("swiped with option Items");
        RecyclerView rv = findViewById(R.id.rv);
        itemList = new ArrayList<>();
        for (int i =0; i < 20; i++){
            MainItem item = new MainItem();
            item.text = i + item.text;
            this.itemList.add(item);
        }
        adapter = new ItemAdapter(itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return true;
            }

            private IItem cachedItem;
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {

                if (viewHolder instanceof ItemAdapter.MainItemHolder){
                    int pos = viewHolder.getAdapterPosition();
                    cachedItem = itemList.remove(pos);
                    adapter.notifyItemRemoved(pos);
                    itemList.add(pos, new OptionItem());
                    adapter.notifyItemInserted(pos);

                }else if(viewHolder instanceof ItemAdapter.OptionItemHolder){
                    int pos = viewHolder.getAdapterPosition();
                    itemList.remove(pos);
                    adapter.notifyItemRemoved(pos);
                    itemList.add(pos, cachedItem);
                    adapter.notifyItemInserted(pos);
                }

            }
        });

        itemTouchHelper.attachToRecyclerView(rv);
        adapter.setOnOptionClickListener((position, option) -> {
            if (option == adapter.EDIT_OPTION){
                Toast.makeText(this, "Edit option selected", Toast.LENGTH_SHORT).show();
            }else if (option == adapter.DELETE_OPTION){
                itemList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }
}
