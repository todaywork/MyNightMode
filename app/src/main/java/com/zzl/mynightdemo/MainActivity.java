
package com.zzl.mynightdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextView;

    private boolean mChecked;

    @BehaviorTrace("onCreatetime")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate ");
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);
        CheckBox checkBox = findViewById(R.id.checkbox);
        if (savedInstanceState != null) {
            boolean ischeck = savedInstanceState.getBoolean("ischeck", false);
            checkBox.setChecked(ischeck);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        map.put("key6", "value6");
        ArrayList<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        map.put("key6", list);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("onCreate " + jsonObject);
    }

    @BehaviorTrace("onSaveInstanceState")
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("ischeck", mChecked);
        Log.d(TAG, "onSaveInstanceState ");
    }

    @BehaviorTrace("onRestoreInstanceState")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState ");
    }

    @BehaviorTrace("onStart")
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart ");
    }

    @BehaviorTrace("onResume")
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy ");
    }

    public void toggleModel(View view) {
        CheckBox checkBox = (CheckBox) view;
        mChecked = checkBox.isChecked();
        Log.d(TAG, "toggleModel checked=" + mChecked);
        if (mChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}
