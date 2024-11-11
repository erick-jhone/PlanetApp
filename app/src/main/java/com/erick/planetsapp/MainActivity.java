package com.erick.planetsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.erick.planetsapp.adapter.ItemListAdapter;
import com.erick.planetsapp.data.ItemListRepository;
import com.erick.planetsapp.model.ItemList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    private ListView listViewQuizOptions;
    private ItemListAdapter adapter;
    private ArrayList<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listViewQuizOptions = findViewById(R.id.listViewQuizOptions);
        makeAdapter();
        listViewQuizOptions.setAdapter(adapter);


    }

    private void makeAdapter(){
        items = ItemListRepository.getMockedItemList();
        adapter = new ItemListAdapter(this, items);
        listViewQuizOptions.setAdapter(adapter);
        listViewQuizOptions.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemList item = (ItemList) parent.getItemAtPosition(position);

        openScreen();
    }


    public void openScreen(){
        Intent intent = new Intent(MainActivity.this, RocketActivity.class);
        startActivity(intent);
    }

}