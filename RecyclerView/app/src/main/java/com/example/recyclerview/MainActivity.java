package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model[] list = { new Model("Item 1", "this is description 1", R.drawable.ic_launcher_background),
                new Model("Item 2", "this is description 2", R.drawable.ic_launcher_background),
                new Model("Item 3", "this is description 3", R.drawable.ic_launcher_background),
                new Model("Item 4", "this is description 4", R.drawable.ic_launcher_background),
                new Model("Item 5", "this is description 5", R.drawable.ic_launcher_background),
                new Model("Item 6", "this is description 6", R.drawable.ic_launcher_background),
                new Model("Item 7", "this is description 7", R.drawable.ic_launcher_background),
                new Model("Item 8", "this is description 8", R.drawable.ic_launcher_background)};
        Adapter adapter = new Adapter(this, list);
        recycler = findViewById(R.id.recyclerView);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}