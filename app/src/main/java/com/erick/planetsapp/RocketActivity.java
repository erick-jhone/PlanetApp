package com.erick.planetsapp;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.erick.planetsapp.R;

public class RocketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);

        ImageView rocketImageView = findViewById(R.id.rocketImageView);

        // Animação de alpha no ImageView
        ObjectAnimator fadeAnimation = ObjectAnimator.ofFloat(rocketImageView, "alpha", 0f, 1f);
        fadeAnimation.setDuration(2000); // 2 segundos
        fadeAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        fadeAnimation.setRepeatMode(ObjectAnimator.REVERSE);
        fadeAnimation.start();

        Drawable drawable = rocketImageView.getDrawable();
        if (drawable instanceof AnimatedVectorDrawable) {
            AnimatedVectorDrawable rocketAnimation = (AnimatedVectorDrawable) drawable;
            rocketAnimation.start();
        }
    }
}