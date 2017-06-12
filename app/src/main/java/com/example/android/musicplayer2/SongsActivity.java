package com.example.android.musicplayer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.musicplayer2.R.id.songTitle;

public class SongsActivity extends AppCompatActivity {

    private List<SongInfo> songs;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_songs);
        FrameLayout playback = (FrameLayout) findViewById(R.id.control_container);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        final TextView playingTitle = (TextView) findViewById(R.id.playing_title);
        final TextView playingArtist = (TextView) findViewById(R.id.playing_artist);
        final ImageView playingPhoto = (ImageView) findViewById(R.id.albumPic);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();

        RVAdapter adapter = new RVAdapter(songs);
        adapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                playingTitle.setText(songs.get(position).SONG);
                playingArtist.setText(songs.get(position).ARTIST);
                playingPhoto.setImageResource(songs.get(position).photoId);
            }
        });
        rv.setAdapter(adapter);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.songActivity);
        }

        if (playback != null) {
            playback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SongsActivity.this, PlayingActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    private void initializeData() {
        songs = new ArrayList<>();
        songs.add(new SongInfo(getString(R.string.song1Title), getString(R.string.song1Artist), R.drawable.album1));
        songs.add(new SongInfo(getString(R.string.song2Title), getString(R.string.song2Artist), R.drawable.album2));
        songs.add(new SongInfo(getString(R.string.song3Title), getString(R.string.song3Artist), R.drawable.album3));
        songs.add(new SongInfo(getString(R.string.song4Title), getString(R.string.song4Artist), R.drawable.album4));
        songs.add(new SongInfo(getString(R.string.song5Title), getString(R.string.song5Artist), R.drawable.album5));
        songs.add(new SongInfo(getString(R.string.sing6Title), getString(R.string.song6Artist), R.drawable.album6));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
