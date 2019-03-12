package com.ninositsolution.inveleapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Parthasarathy D on 1/17/2019.
 * Ninos IT Solution Pvt Ltd
 * ben@ninositsolution.com
 */
public class Session {

    private String CategoryPosition = "CategoryPosition";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static final String device_id = "device_id";

    public Session(Context context)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    public int getCategoryPosition() {
       return preferences.getInt(CategoryPosition, 1);
    }

    public void setCategoryPosition(int categoryPosition) {
        editor.putInt(CategoryPosition, categoryPosition).apply();
    }

    public static String getDevice_id(Context context) {
        return context.getSharedPreferences("Session", Context.MODE_PRIVATE).getString(device_id, "0");
    }

    public static void setDevice_id(String values, Context context) {
        context.getSharedPreferences("Session", Context.MODE_PRIVATE).edit().putString(device_id, values).apply();
    }
}
