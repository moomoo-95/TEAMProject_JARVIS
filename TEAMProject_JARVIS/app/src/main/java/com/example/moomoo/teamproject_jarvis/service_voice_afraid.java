package com.example.moomoo.teamproject_jarvis;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class service_voice_afraid extends Service {
    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate(){
        player = MediaPlayer.create(this, R.raw.voice_afraid);
        player.setLooping(false);
    }
    public void onDestroy(){
        player.stop();
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
