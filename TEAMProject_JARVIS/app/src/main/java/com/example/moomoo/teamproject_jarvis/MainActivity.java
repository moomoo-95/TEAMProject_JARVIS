package com.example.moomoo.teamproject_jarvis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    boolean soundcheck = true;
    ImageButton soundbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_to_start);
        startService(new Intent(this, service_backgroundmusic.class));
    }
    public void mainmenuclick(View view){
        startService(new Intent(this, service_voice_service.class));
        Intent intent = null;
        switch (view.getId()){
            case R.id.calculator_basic:
                intent = new Intent(MainActivity.this, calculator_main.class);
                break;
            case R.id.ruler_basic:
                intent = new Intent(MainActivity.this, ruler.class);
                break;
            case R.id.todo_life:
                intent = new Intent(MainActivity.this, simpletodo.class);
                break;
            case R.id.accounts_app:
                intent = new Intent(MainActivity.this, account.class);
                break;
            case R.id.water_app:
                intent = new Intent(MainActivity.this, water_app.class);
                break;
            case R.id.food_life:
                intent = new Intent(MainActivity.this, food_app.class);
                break;
            case R.id.drunk_life:
                intent = new Intent(MainActivity.this, drunk.class);
                break;
            case R.id.dessert_life:
                intent = new Intent(MainActivity.this, dessert.class);
                break;

            case R.id.random_game:
                intent = new Intent(MainActivity.this, randomupdown.class);
                break;
            case R.id.fan_app:
                intent = new Intent(MainActivity.this, fan_app.class);
                break;
        }
        startActivity(intent);
    }
    public void touchstart(View view){
        if(view.getId() == R.id.touch ){
            setContentView(R.layout.main_jarvis);
            soundbtn = (ImageButton)findViewById(R.id.bgm);
            soundbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundcheck = !soundcheck;
                    if(soundcheck == true){
                        soundbtn.setImageResource(R.drawable.sound_on);
                        startService(new Intent(MainActivity.this, service_backgroundmusic.class));
                    }
                    else{
                        soundbtn.setImageResource(R.drawable.sound_off);
                        stopService(new Intent(MainActivity.this, service_backgroundmusic.class));
                    }
                }
            });
        }

    }
}