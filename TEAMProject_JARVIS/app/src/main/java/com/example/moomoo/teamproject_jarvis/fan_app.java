package com.example.moomoo.teamproject_jarvis;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fan_app extends AppCompatActivity {
    public static boolean spining = false;
    public static int spinmode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_app);
        findViewById(R.id.spin_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(fan_app.this, service_voice_check.class));
                spining = true;
            }
        });
        findViewById(R.id.spin_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(fan_app.this, service_voice_check.class));
                spining = false;
            }
        });
        findViewById(R.id.spin_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(fan_app.this, service_voice_check.class));
                spinmode = 1;
            }
        });
        findViewById(R.id.spin_white).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(fan_app.this, service_voice_check.class));
                spinmode = 2;
            }
        });
        findViewById(R.id.spin_gold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(fan_app.this, service_voice_check.class));
                spinmode = 3;
            }
        });
    }
}
