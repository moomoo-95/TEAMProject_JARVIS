package com.example.moomoo.teamproject_jarvis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ruler extends AppCompatActivity {
    ImageView cmvie,inchv;
    TextView history;
    LinearLayout mainlayout;
    RadioButton cmbtn;
    String temp = "";
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int getDeviceHeight_Pixel = displayMetrics.heightPixels;
        int getDeviceWidth_Pixel = displayMetrics.widthPixels;
        final int getDeviceDpi = displayMetrics.densityDpi;
        cmvie = findViewById(R.id.cmrul);
        inchv = (ImageView)findViewById(R.id.inchru);
        history = (TextView)findViewById(R.id.historytext);
        cmbtn = (RadioButton)findViewById(R.id.cmbtn);
        mainlayout = (LinearLayout)findViewById(R.id.fullscreen);
        mainlayout.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event){
                float cm;
                cm = (float) ((event.getY()*25.4)/getDeviceDpi);
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        if(cmbtn.isChecked()) {
                            cm = cm/10;
                            history.setText(i+".  "+String.format("%.2f", cm) + "cm\n"+temp);
                        }
                        else{
                            cm = (float) (cm/25.4);
                            history.setText(i+".  "+String.format("%.2f", cm) + "inch\n"+temp);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if(cmbtn.isChecked()) {
                            cm = cm/10;
                            temp = i+".  "+ String.format("%.2f", cm) + "cm\n"+ temp;
                        }
                        else{
                            cm = (float) (cm/25.4);
                            temp = i +".  "+ String.format("%.2f", cm) + "inch\n"+ temp;
                        }
                        history.setText(temp);
                        i++;
                        break;
                }
                return true;
            }
        });
    }
    public void modeclick(View view){
        switch (view.getId()){
            case R.id.cmbtn:
                inchv.setVisibility(View.GONE);
                cmvie.setVisibility(View.VISIBLE);
                break;
            case R.id.inchbtn:
                cmvie.setVisibility(View.GONE);
                inchv.setVisibility(View.VISIBLE);
                break;
            case R.id.resetbtn:
                i = 1;
                temp = "";
                history.setText("");
                break;
        }
    }
}