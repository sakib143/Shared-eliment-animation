package com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mikescamell.sharedelementtransitions.R;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalGalleryAdapter;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItem;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItemClickListener;
import com.mikescamell.sharedelementtransitions.recycler_view.Utils;

public class RecyclerViewActivity extends AppCompatActivity implements AnimalItemClickListener {

    public static final String EXTRA_ANIMAL_ITEM = "animal_image_url";
    public static final String EXTRA_ANIMAL_IMAGE_TRANSITION_NAME = "animal_image_transition_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        AnimalGalleryAdapter animalGalleryAdapter = new AnimalGalleryAdapter(Utils.generateAnimalItems(this), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(animalGalleryAdapter);
    }

    @Override
    public void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView sharedImageView) {
        Intent intent = new Intent(this, AnimalDetailActivity.class);
        intent.putExtra(EXTRA_ANIMAL_ITEM, animalItem);
        intent.putExtra(EXTRA_ANIMAL_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(sharedImageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                sharedImageView,
                ViewCompat.getTransitionName(sharedImageView));

        startActivity(intent, options.toBundle());
    }

}