package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> friendsList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.friendsListView);
        editText=findViewById(R.id.friendNameText);
        friendsList=new ArrayList<String>();
        friendsList.add("adil");
        friendsList.add("waleed");
        arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendsList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("friend_name", friendsList.get(position));
                startActivity(intent);
            }
        });
    }

    public void addFriend(View view) {
        String name=editText.getText().toString();
        name=name.trim();
        if(!name.isEmpty())
        {
            friendsList.add(name);
            Collections.sort(friendsList);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}