package com.erick.planetsapp.data;


import com.erick.planetsapp.R;
import com.erick.planetsapp.model.ItemList;

import java.util.ArrayList;

public class ItemListRepository {

    public static ArrayList<ItemList> getMockedItemList() {
        ArrayList<ItemList> itemList = new ArrayList<>();
        itemList.add(new ItemList("Terra", R.drawable.planeta_terra));
        itemList.add(new ItemList("Marte", R.drawable.marte));
        itemList.add(new ItemList("Venus", R.drawable.venus_vetor));
        itemList.add(new ItemList("Saturno", R.drawable.saturno));
        return itemList;
    }
}