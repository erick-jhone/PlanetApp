package com.erick.planetsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.erick.planetsapp.utils.NavigationUtils;

public class RocketActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);

        ImageView rocketImageView = findViewById(R.id.rocketImageView);
        rocketImageView.setImageResource(R.drawable.rocket_and_planet);
        textView = findViewById(R.id.textPlanet);


        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rocketImageView.startAnimation(rotateAnimation);

        Intent intent = getIntent();
        String textPlanet = intent.getStringExtra(NavigationUtils.NAVIGATION_ARGUMENT_PLANET);
        textView.setText("Viajando para " + textPlanet);
    }
}