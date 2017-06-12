package com.example.android.musicplayer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getString(R.string.songActivity));

        TextView song = (TextView) findViewById(R.id.SongActivity);
        TextView artist = (TextView) findViewById(R.id.ArtistActivity);
        TextView tag = (TextView) findViewById(R.id.TagActivity);
        FrameLayout playback = (FrameLayout) findViewById(R.id.control_container);

        if (song != null) {
            song.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent songIntent = new Intent(MainActivity.this, SongsActivity.class);
                    startActivity(songIntent);
                }
            });
        }
        if (artist != null) {
            artist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent artistIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                    startActivity(artistIntent);
                }
            });
        }
        if (tag != null) {
            tag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tagIntent = new Intent(MainActivity.this, TagsActivity.class);
                    startActivity(tagIntent);
                }
            });
        }
        if (playback != null) {
            playback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, PlayingActivity.class);
                    startActivity(i);
                }
            });
        }
    }
}
