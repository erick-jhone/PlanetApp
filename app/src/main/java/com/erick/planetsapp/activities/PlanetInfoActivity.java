package com.erick.planetsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.erick.planetsapp.R;
import com.erick.planetsapp.data.PlanetRepository;
import com.erick.planetsapp.model.Planet;
import com.erick.planetsapp.utils.NavigationUtils;

public class PlanetInfoActivity extends AppCompatActivity {

    TextView[] characteristics = new TextView[3];
    TextView textViewPlanetName;
    ImageView imageViewPlanet;
    String planetName;
    Button buttonToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planet_info);

        initUIComponents();
        setupListeners();
        getExtras();
        setPlanetInfo();
    }

    private void initUIComponents() {
        imageViewPlanet = findViewById(R.id.planetImage);
        textViewPlanetName = findViewById(R.id.planetName);
        characteristics[0] = findViewById(R.id.characteristic1);
        characteristics[1] = findViewById(R.id.characteristic2);
        characteristics[2] = findViewById(R.id.characteristic3);
        buttonToHome = findViewById(R.id.buttonToHome);
    }

    public void setupListeners() {
        buttonToHome.setOnClickListener(v -> {
            NavigationUtils.navigateReorderToFront(this, MainActivity.class);
        }
      );
    }

    private void getExtras() {
        Intent intent = getIntent();
        planetName = intent.getStringExtra(NavigationUtils.NAVIGATION_ARGUMENT_PLANET);
    }

    private void setPlanetInfo() {
        PlanetRepository planetRepository = new PlanetRepository(this);
        Planet planet = planetRepository.getPlanetListByName(planetName);
        textViewPlanetName.setText(planet.getName());
        imageViewPlanet.setImageResource(planet.getImage());
        for (int i = 0; i < 3; i++) {
            characteristics[i].setText(planet.getCharacteristics()[i]);
        }
    }
}