package com.erick.planetsapp.activities;

import static com.erick.planetsapp.utils.NavigationUtils.NAVIGATION_ARGUMENT_PLANET;
import static com.erick.planetsapp.utils.NavigationUtils.NAVIGATION_KEY_EARTH;
import static com.erick.planetsapp.utils.NavigationUtils.NAVIGATION_KEY_MARS;
import static com.erick.planetsapp.utils.NavigationUtils.NAVIGATION_KEY_SATURN;
import static com.erick.planetsapp.utils.NavigationUtils.NAVIGATION_KEY_VENUS;
import static com.erick.planetsapp.utils.NavigationUtils.navigate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.erick.planetsapp.R;
import com.erick.planetsapp.adapter.ConfirmDeleteDialog;
import com.erick.planetsapp.adapter.ItemListAdapter;
import com.erick.planetsapp.data.ItemListRepository;
import com.erick.planetsapp.model.ItemList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView listViewOptions;
    private ItemListAdapter adapter;
    private ArrayList<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listViewOptions = findViewById(R.id.listViewOptions);
        makeAdapter();
        listViewOptions.setAdapter(adapter);
    }

    private void makeAdapter(){
        if(items == null){
            items = ItemListRepository.getMockedItemList();
        }
        adapter = new ItemListAdapter(this, items);
        listViewOptions.setAdapter(adapter);
        listViewOptions.setOnItemClickListener(this);
        listViewOptions.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemList item = (ItemList) parent.getItemAtPosition(position);
        openScreen(item.getData());
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        ConfirmDeleteDialog dialog = new ConfirmDeleteDialog();
        dialog.setConfirmDeleteListener(new ConfirmDeleteDialog.ConfirmDeleteListener() {
            @Override
            public void onConfirmDelete() {
                items.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        dialog.show(getSupportFragmentManager(), "ConfirmDeleteDialog");
        return true;
    }

    public void openScreen(String planet) {

        switch(planet) {
            case NAVIGATION_KEY_MARS:
                navigate(MainActivity.this, RocketActivity.class, NAVIGATION_ARGUMENT_PLANET, NAVIGATION_KEY_MARS);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case NAVIGATION_KEY_EARTH:
                navigate(MainActivity.this, RocketActivity.class, NAVIGATION_ARGUMENT_PLANET, NAVIGATION_KEY_EARTH);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case NAVIGATION_KEY_SATURN:
                navigate(MainActivity.this, RocketActivity.class, NAVIGATION_ARGUMENT_PLANET, NAVIGATION_KEY_SATURN);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case NAVIGATION_KEY_VENUS:
                navigate(MainActivity.this, RocketActivity.class, NAVIGATION_ARGUMENT_PLANET, NAVIGATION_KEY_VENUS);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
    }
}