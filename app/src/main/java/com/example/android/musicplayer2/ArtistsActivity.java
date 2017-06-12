package com.example.android.musicplayer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_artists);
        FrameLayout playback = (FrameLayout) findViewById(R.id.control_container);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.artistActivity);
        }

        if (playback != null) {
            playback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ArtistsActivity.this, PlayingActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
