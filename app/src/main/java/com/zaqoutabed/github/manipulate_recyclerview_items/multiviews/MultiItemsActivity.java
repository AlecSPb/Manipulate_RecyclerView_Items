package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zaqoutabed.github.manipulate_recyclerview_items.R;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items.IItem;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items.ImagePostItem;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items.TextPostItem;
import com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items.VideoPostItem;

import java.util.ArrayList;
import java.util.List;

public class MultiItemsActivity extends AppCompatActivity {
    private List<IItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_items);
        getSupportActionBar().setTitle("Multi View Item");

        RecyclerView recyclerView = findViewById(R.id.rv);
        itemList = new ArrayList<>();
        addDataToList();
        ItemsAdapter adapter = new ItemsAdapter(itemList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void addDataToList() {

        String videoPath = "android.resource://com.zaqoutabed.github.customandroidrecyclerview/"+R.raw.sample;
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        itemList.add(new TextPostItem("Faraj", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Faraj", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("abed", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Ahmed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Ahmed", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Khalid", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Khalid", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Ahmed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));


        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Ahmed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("abed", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Ahmed", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("abed", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Khalid", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));


        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Ahmed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("Khalid", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new VideoPostItem("Osama", R.drawable.avatar,videoPath, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new TextPostItem("abed", R.drawable.avatar,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

        itemList.add(new ImagePostItem("abed", R.drawable.avatar,R.drawable.post_image, "The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));
        itemList.add(new ImagePostItem("Ahmed", R.drawable.avatar,R.drawable.post_image,"The standard Lorem Ipsum passage The standard Lorem Ipsum passage"));

    }
}