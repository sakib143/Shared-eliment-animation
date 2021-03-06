package com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mikescamell.sharedelementtransitions.R;

public class RecyclerViewToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, RecyclerViewFragment.newInstance())
                .commit();
    }
}
