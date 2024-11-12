package com.erick.planetsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.erick.planetsapp.R;
import com.erick.planetsapp.utils.NavigationUtils;

public class RocketActivity extends AppCompatActivity {

    TextView textView;
    String textPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);

        InitUIComponents();
        getExtras();
        goToPlanetInfoScreen();
    }

    private void goToPlanetInfoScreen() {
        new Handler().postDelayed(() -> NavigationUtils.navigateAndPop(RocketActivity.this,
                PlanetInfoActivity.class,
                NavigationUtils.NAVIGATION_ARGUMENT_PLANET,
                textPlanet), 7000);
    }

    private void getExtras() {
        Intent intent = getIntent();
        textPlanet = intent.getStringExtra(NavigationUtils.NAVIGATION_ARGUMENT_PLANET);
        textView.setText("Viajando para " + textPlanet);
    }

    private void InitUIComponents() {
        ImageView rocketImageView = findViewById(R.id.rocketImageView);
        rocketImageView.setImageResource(R.drawable.rocket_and_planet);
        textView = findViewById(R.id.textPlanet);

        setupAnimation(rocketImageView);
    }

    private void setupAnimation(ImageView rocketImageView) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rocketImageView.startAnimation(rotateAnimation);
    }





}