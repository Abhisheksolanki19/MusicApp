package com.merchpandas.musicapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicDetails extends AppCompatActivity implements View.OnClickListener {
    private String songName;
    private String artistName;

    @BindView(R.id.prevButton)
    ImageButton prevButton;
    @BindView(R.id.playButton)
    ImageButton playButton;
    @BindView(R.id.nextButton)
    ImageButton nextButton;
    private RelativeLayout rootLayout;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rootLayout = findViewById(R.id.constraint_layout);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        Intent intent = getIntent();
        songName = intent.getStringExtra("songName");
        artistName = intent.getStringExtra("artistName");

        TextView songNameTv = findViewById(R.id.detail_song_name);
        songNameTv.setText(songName);
        TextView artistNameTv = findViewById(R.id.detail_artist_name);
        artistNameTv.setText("Artist: " + artistName);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.prevButton:
                Toast.makeText(MusicDetails.this, "Previous Song is Playing", Toast.LENGTH_SHORT).show();
                break;
            case R.id.playButton:
                Toast.makeText(MusicDetails.this, "Song is Playing", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextButton:
                Toast.makeText(MusicDetails.this, "Next Song is Playing", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
