package com.erick.planetsapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.erick.planetsapp.R;

public class NavigationUtils {

    // Argumentos de navegação
    public static final String NAVIGATION_ARGUMENT_PLANET = "planet";

    // Chaves
    public static final String NAVIGATION_KEY_EARTH = "Terra";
    public static final String NAVIGATION_KEY_MARS = "Marte";
    public static final String NAVIGATION_KEY_VENUS = "Venus";
    public static final String NAVIGATION_KEY_SATURN = "Saturno";

    public static void navigate(Context context, Class<?> destination) {
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);
    }

    public static void navigate(Context context, Class<?> destination, String key, String value) {
        Intent intent = new Intent(context, destination);
        intent.putExtra(key, value);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public static void navigateAndPop(Context context, Class<?> destination) {
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
