package com.mikescamell.sharedelementtransitions.simple_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.mikescamell.sharedelementtransitions.R;

public class SimpleActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        final ImageView imageView = (ImageView) findViewById(R.id.simple_activity_a_imageView);

        Button button = (Button) findViewById(R.id.simple_activity_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivityA.this, SimpleActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SimpleActivityA.this,
                        imageView,
                        ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

    }
}
