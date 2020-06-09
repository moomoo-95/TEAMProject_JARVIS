package com.example.moomoo.teamproject_jarvis;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class service_random_dessert extends Service {
    private final IBinder mBinder = new dessert_Binder();
    private final Random mRandom = new Random();
    public class dessert_Binder extends Binder{
        service_random_dessert getService(){
            return  service_random_dessert.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    public int getRandomDessert(){
        return mRandom.nextInt(40);
    }
}
