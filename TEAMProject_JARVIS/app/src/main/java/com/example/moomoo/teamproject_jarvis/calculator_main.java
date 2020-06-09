package com.example.moomoo.teamproject_jarvis;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class calculator_main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
        getFragmentManager().beginTransaction().add(R.id.fragment_container, new calculator1Fragment()).commit();

    }
    public void btnclickcalmain(View view){
        Fragment fr = null;
        startService(new Intent(this, service_voice_check.class));
        switch (view.getId()){
            case R.id.standard:
                fr = new calculator1Fragment();
                break;
            case R.id.nbbang:
                fr = new calculator2Fragment();
                break;
            case R.id.monthmoney:
                fr = new calculator3Fragment();
                break;
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fr).commit();
    }
}
