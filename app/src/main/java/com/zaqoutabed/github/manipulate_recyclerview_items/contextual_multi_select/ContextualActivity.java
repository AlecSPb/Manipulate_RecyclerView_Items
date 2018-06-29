package com.zaqoutabed.github.manipulate_recyclerview_items.contextual_multi_select;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.MainActivity;
import com.zaqoutabed.github.manipulate_recyclerview_items.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextualActivity extends AppCompatActivity implements View.OnLongClickListener{

    private OnContextualModeListener onContextualModeListener;

    private RecyclerView rv;
    private List<Item> itemList;
    private LinearLayoutManager linearLayoutManager;
    private ItemAdapter adapter;
    private ActionMode mActionmode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual);
        rv = findViewById(R.id.rv);
        getSupportActionBar().setTitle("Select multi Items");

        linearLayoutManager = new LinearLayoutManager(this);

        itemList = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            Item item = new Item();
            item.text = String.valueOf(i) + " " + item.text;
            itemList.add(item);
        }
        adapter = new ItemAdapter(itemList, this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);


        adapter.setOnItemChecked((status, position, item) -> {
            if (status){
                selectedData.add(item);
            }else {
                selectedData.size();
            }
            mActionmode.setTitle(String.valueOf(selectedData.size()) + " item selected");
        });
    }
    private ArrayList<Item> selectedData = new ArrayList<>();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit_menu_opt:
                Toast.makeText(this, "Edit Option Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search_menu_opt:
                Toast.makeText(this, "Search Option Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default: return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public boolean onLongClick(View v) {
        mActionmode = startActionMode(mActionModeCallback);
        mActionmode.setTitle("0 item selected");
        return true;
    }
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.context_menu,menu);
            if (onContextualModeListener != null)
                onContextualModeListener.onContextualMode(true);
            adapter.notifyDataSetChanged();
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.delete_menu_opt:
                    for (int i = 0; i < selectedData.size(); i++){
                        Item item1 = selectedData.get(i);
                        itemList.remove(item1);
                    }
                    selectedData.clear();
                    mActionmode.setTitle("0 item selected");
                    mode.finish();
                    adapter.notifyDataSetChanged();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            if (onContextualModeListener != null)
                onContextualModeListener.onContextualMode(false);
            adapter.notifyDataSetChanged();
            mActionmode = null;
        }
    };

    public void setOnContextualModeListener(OnContextualModeListener onContextualModeListener) {
        this.onContextualModeListener = onContextualModeListener;
    }
}
