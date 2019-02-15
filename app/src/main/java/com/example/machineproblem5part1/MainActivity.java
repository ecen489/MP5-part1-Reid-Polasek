package com.example.machineproblem5part1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean stopped = true;
    int songNo = 1;
    MediaPlayer player;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picture = findViewById(R.id.imageView);
    }

    public void radioClick(android.view.View a){
            if (a.getId()==R.id.song1){
                songNo = 1;
                picture.setImageResource(R.drawable.warhymn);
            }
            else if (a.getId()==R.id.song2){
                songNo = 2;
                picture.setImageResource(R.drawable.spiritofaggieland);
            }
            else{
                songNo = 3;
                picture.setImageResource(R.drawable.cover);
            }
    }

    public void pause(android.view.View a){
        if (!stopped){
            player.pause();
        }
    }

    public void stop(android.view.View a){
        if (!stopped){
            player.stop();
            player.release();
            stopped = true;
        }
    }

    public void play(android.view.View a){
        if (stopped){
            if (songNo == 1){
                player = MediaPlayer.create(this,R.raw.aggiewarhymn);
            }
            else if (songNo == 2){
                player = MediaPlayer.create(this,R.raw.spiritofaggieland);
            }
            else{
                player = MediaPlayer.create(this,R.raw.bobe3);
            }
            stopped = false;
        }
        player.start();
    }
}
