package com.example.moomoo.teamproject_jarvis;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class calculator1Fragment extends Fragment {
    TextView whiletext, thistext, resulttext;
    int calCheck = 0;
    public calculator1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View mainview = inflater.inflate(R.layout.fragment_calculator1, container, false);
        whiletext = (TextView)mainview.findViewById(R.id.whiletext1);
        thistext = (TextView)mainview.findViewById(R.id.thistext1);
        resulttext = (TextView)mainview.findViewById(R.id.resulttext1);
        mainview.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thistext.setText("0");
            }
        });
        mainview.findViewById(R.id.allcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thistext.setText("0");
                whiletext.setText("");
                resulttext.setText("0");
                calCheck = 0;
            }
        });
        mainview.findViewById(R.id.onecancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.length() == 1){
                    thistext.setText("0");
                }
                else if(tempstr.length() > 0){
                    thistext.setText(tempstr.substring(0, tempstr.length()-1));
                }
            }
        });
        mainview.findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(!tempstr.contains(".")) { thistext.setText(tempstr + "."); }
            }
        });
        mainview.findViewById(R.id.zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(!tempstr.equals("0")){
                    thistext.setText(tempstr + "0");
                }
            }
        });
        mainview.findViewById(R.id.doublezero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(!tempstr.equals("0")){
                    thistext.setText(tempstr + "00");
                }
            }
        });
        mainview.findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("1"); }
                else { thistext.setText(tempstr + "1"); }
            }
        });
        mainview.findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("2"); }
                else { thistext.setText(tempstr + "2"); }
            }
        });
        mainview.findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("3"); }
                else { thistext.setText(tempstr + "3"); }
            }
        });
        mainview.findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("4"); }
                else { thistext.setText(tempstr + "4"); }
            }
        });
        mainview.findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("5"); }
                else { thistext.setText(tempstr + "5"); }
            }
        });
        mainview.findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("6"); }
                else { thistext.setText(tempstr + "6"); }
            }
        });
        mainview.findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("7"); }
                else { thistext.setText(tempstr + "7"); }
            }
        });
        mainview.findViewById(R.id.eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("8"); }
                else { thistext.setText(tempstr + "8"); }
            }
        });
        mainview.findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                if(tempstr.equals("0")){ thistext.setText("9"); }
                else { thistext.setText(tempstr + "9"); }
            }
        });
        mainview.findViewById(R.id.division).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                String wstr = whiletext.getText().toString();
                double result = Double.parseDouble(resulttext.getText().toString());
                if(whiletext.getText().toString().equals("")&&thistext.getText().toString().equals("0")){
                    Toast.makeText(mainview.getContext(), "숫자를 누르세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!tempstr.equals("0") && !tempstr.equals("0.")){
                    whiletext.setText(wstr + tempstr+"÷");
                    thistext.setText("0");
                    calcul(result, tempstr);
                    calCheck = 1;
                }
                else if(whiletext.length() != 0){
                    wstr = wstr.substring(0, wstr.length()-1);
                    whiletext.setText(wstr+"÷");
                    calCheck = 1;
                }
            }
        });
        mainview.findViewById(R.id.multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                String wstr = whiletext.getText().toString();
                double result = Double.parseDouble(resulttext.getText().toString());
                if(whiletext.getText().toString().equals("")&&thistext.getText().toString().equals("0")){
                    Toast.makeText(mainview.getContext(), "숫자를 누르세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!tempstr.equals("0") && !tempstr.equals("0.")){
                    whiletext.setText(wstr + tempstr+"×");
                    thistext.setText("0");
                    calcul(result, tempstr);
                    calCheck = 2;
                }
                else if(whiletext.length() != 0){
                    wstr = wstr.substring(0, wstr.length()-1);
                    whiletext.setText(wstr+"×");
                    calCheck = 2;
                }
            }
        });
        mainview.findViewById(R.id.subtrac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                String wstr = whiletext.getText().toString();
                double result = Double.parseDouble(resulttext.getText().toString());
                if(whiletext.getText().toString().equals("")&&thistext.getText().toString().equals("0")){
                    Toast.makeText(mainview.getContext(), "숫자를 누르세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!tempstr.equals("0") && !tempstr.equals("0.")){
                    whiletext.setText(wstr + tempstr+"－");
                    thistext.setText("0");
                    calcul(result, tempstr);
                    calCheck = 3;
                }
                else if(whiletext.length() != 0){
                    wstr = wstr.substring(0, wstr.length()-1);
                    whiletext.setText(wstr+"－");
                    calCheck = 3;
                }
            }
        });
        mainview.findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                String wstr = whiletext.getText().toString();
                double result = Double.parseDouble(resulttext.getText().toString());
                if(whiletext.getText().toString().equals("")&&thistext.getText().toString().equals("0")){
                    Toast.makeText(mainview.getContext(), "숫자를 누르세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!tempstr.equals("0") && !tempstr.equals("0.")){
                    whiletext.setText(wstr + tempstr+"＋");
                    thistext.setText("0");
                    calcul(result, tempstr);
                    calCheck = 4;
                }
                else if(whiletext.length() != 0){
                    wstr = wstr.substring(0, wstr.length()-1);
                    whiletext.setText(wstr+"＋");
                    calCheck = 4;
                }
            }
        });
        mainview.findViewById(R.id.equl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempstr = thistext.getText().toString();
                double result = Double.parseDouble(resulttext.getText().toString());
                if(whiletext.getText().toString().equals("")&&thistext.getText().toString().equals("0")){
                    Toast.makeText(mainview.getContext(), "숫자를 누르세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    whiletext.setText("");
                    thistext.setText("0");
                    calcul(result, tempstr);
                    calCheck = 0;
                }
            }
        });
        return mainview;
    }
    private void calcul(double d, String t){
        switch (calCheck){
            case 0:
                d = Double.parseDouble(t);
                break;
            case 1:
                d /= Double.parseDouble(t);
                break;
            case 2:
                d *= Double.parseDouble(t);
                break;
            case 3:
                d -= Double.parseDouble(t);
                break;
            case 4:
                d += Double.parseDouble(t);
                break;
        }
        resulttext.setText(String.valueOf(d));
    }

}
