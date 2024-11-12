package com.erick.planetsapp.data;

import android.content.Context;

import com.erick.planetsapp.R;
import com.erick.planetsapp.model.ItemList;
import com.erick.planetsapp.model.Planet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlanetRepository {

    private final List<Planet> planetList;

    public PlanetRepository(Context context) {
        this.planetList = new ArrayList<>();
        planetList.add(new Planet("Terra", R.drawable.earth, context.getResources().getStringArray(R.array.Terra)));
        planetList.add(new Planet("Venus", R.drawable.venus, context.getResources().getStringArray(R.array.Venus)));
        planetList.add(new Planet("Marte", R.drawable.mars, context.getResources().getStringArray(R.array.Marte)));
        planetList.add(new Planet("Saturno", R.drawable.saturn, context.getResources().getStringArray(R.array.Saturno)));
    }

    public Planet getPlanetListByName(String planetName) {

        for (Planet planet : planetList) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                return planet;
            }
        }
        return null;
    }
}
