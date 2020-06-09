package com.example.moomoo.teamproject_jarvis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Random;

public class randomupdown extends AppCompatActivity {
    Random r=new Random();
    int RandomNumber=r.nextInt(20)+1;
    NumberPicker numberPicker1, numberPicker2, numberPicker3;
    Button button1, button2, button3;


    public void toastCheck(String check){
        Toast.makeText(randomupdown.this,check, Toast.LENGTH_SHORT).show();
    }

    public void guess1(View view)
    {

        // int number=Integer.parseInt(value.getText().toString());
        int number = numberPicker1.getValue();

        if(RandomNumber > number)
        {
            toastCheck("숫자 UP!!");

            button2.setEnabled(true);



            numberPicker2.setEnabled(true);


        }
        else if(RandomNumber < number)
        {
            toastCheck("숫자 DOWN!!");

            button2.setEnabled(true);



            numberPicker2.setEnabled(true);

        }
        else
        {
            startService(new Intent(this, service_voice_congratulation.class));
            toastCheck("정답!!");
            RandomNumber = r.nextInt(20)+1;
            Restart(view);
        }
        button1.setEnabled(false);
        numberPicker1.setEnabled(false);
    }

    public void guess2(View view)
    {

        // int number=Integer.parseInt(value.getText().toString());
        int number = numberPicker2.getValue();

        if(RandomNumber > number)
        {
            toastCheck("숫자 UP!!");

            button3.setEnabled(true);

            numberPicker3.setEnabled(true);
        }
        else if(RandomNumber < number)
        {
            toastCheck("숫자 DOWN!!");

            button3.setEnabled(true);

            numberPicker3.setEnabled(true);
        }
        else
        {
            startService(new Intent(this, service_voice_congratulation.class));
            toastCheck("정답!!");
            RandomNumber = r.nextInt(20)+1;
            Restart(view);
        }
        button2.setEnabled(false);
        numberPicker2.setEnabled(false);
    }

    public void guess3(View view)
    {

        // int number=Integer.parseInt(value.getText().toString());
        int number = numberPicker3.getValue();

        if(RandomNumber > number)
        {
            toastCheck("정답은 " +RandomNumber +"입니다!");
        }
        else if(RandomNumber < number)
        {
            toastCheck("정답은 " +RandomNumber +"입니다!");
        }
        else
        {
            startService(new Intent(this, service_voice_congratulation.class));
            toastCheck("정답!!");
            RandomNumber = r.nextInt(20)+1;
            Restart(view);
        }
        button3.setEnabled(false);
        numberPicker3.setEnabled(false);
    }

    public void Restart(View view)
    {

        RandomNumber = r.nextInt(20)+1;

        button1.setEnabled(true);
        numberPicker1.setEnabled(true);
        button3.setEnabled(false);
        numberPicker3.setEnabled(false);
        button2.setEnabled(false);
        numberPicker2.setEnabled(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomupdown);
        button1  = (Button)findViewById(R.id.btn1);
        button2  = (Button)findViewById(R.id.btn2);
        button3 =   (Button)findViewById(R.id.btn3);

        numberPicker1 = findViewById(R.id.numpick1);
        numberPicker1.setMinValue(1);
        numberPicker1.setMaxValue(20);
        numberPicker1.setWrapSelectorWheel(false);
        numberPicker1.setBackgroundColor(Color.WHITE);


        numberPicker2 = findViewById(R.id.numpick2);
        numberPicker2.setMinValue(1);
        numberPicker2.setMaxValue(20);
        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setBackgroundColor(Color.WHITE);


        numberPicker3 = findViewById(R.id.numpick3);
        numberPicker3.setMinValue(1);
        numberPicker3.setMaxValue(20);
        numberPicker3.setWrapSelectorWheel(false);
        numberPicker3.setBackgroundColor(Color.WHITE);

        button1.setEnabled(true);
        button2.setEnabled(false);
        button3.setEnabled(false);

        numberPicker1.setEnabled(true);
        numberPicker2.setEnabled(false);
        numberPicker3.setEnabled(false);


        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

        numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

    }
}
