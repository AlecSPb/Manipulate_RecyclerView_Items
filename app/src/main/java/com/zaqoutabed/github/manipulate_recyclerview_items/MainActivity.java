package com.zaqoutabed.github.manipulate_recyclerview_items;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.zaqoutabed.github.manipulate_recyclerview_items.contextual_multi_select.ContextualActivity;
import com.zaqoutabed.github.manipulate_recyclerview_items.moved.DraggableItemActivity;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.MultiItemsActivity;
import com.zaqoutabed.github.manipulate_recyclerview_items.swiped.SwipedItemActivity;
import com.zaqoutabed.github.manipulate_recyclerview_items.swiped_options.SwipedOptionsItemActivity;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button multiViewTypeItemButton = findViewById(R.id.multi_view_type_item_button),
                    dragAndDropItemButton = findViewById(R.id.drag_and_drop_item_button),
                    swipedItemButton = findViewById(R.id.swiped_item_button),
                    swipedOptionItemButton = findViewById(R.id.swiped_option_item_button),
                    multi_select_item_button = findViewById(R.id.multi_select_item_button);

            multiViewTypeItemButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, MultiItemsActivity.class);
                startActivity(intent);
            });
            dragAndDropItemButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, DraggableItemActivity.class);
                startActivity(intent);
            });
            swipedItemButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, SwipedItemActivity.class);
                startActivity(intent);
            });
            swipedOptionItemButton.setOnClickListener(v->{
                Intent intent = new Intent(this, SwipedOptionsItemActivity.class);
                startActivity(intent);
            });
            multi_select_item_button.setOnClickListener(v->{
                Intent intent = new Intent(this, ContextualActivity.class);
                startActivity(intent);
            });
        }
}