package com.example.moomoo.teamproject_jarvis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class calculator2Fragment extends Fragment {
    TextView whiletext;
    EditText totaltext, peopletext;
    public calculator2Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_calculator2, container, false);
        whiletext = (TextView)view.findViewById(R.id.whiletext2);
        totaltext = (EditText) view.findViewById(R.id.totalcoin2);
        peopletext = (EditText) view.findViewById(R.id.nbbangpeople2);
        view.findViewById(R.id.nbbangcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whiletext.setText("");
                totaltext.setText("");
                peopletext.setText("");
            }
        });
        view.findViewById(R.id.won1000).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int won = 1000;
                int temp, nresult, nlost, npeople, npeople2;
                if(totaltext.getText().toString().equals("0") || peopletext.getText().toString().equals("0")){
                    Toast.makeText(view.getContext(), "0은 입력하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!totaltext.getText().toString().equals("") && !peopletext.getText().toString().equals("")) {
                    whiletext.setText("");
                    nresult = Integer.parseInt(totaltext.getText().toString());
                    npeople = Integer.parseInt(peopletext.getText().toString());
                    nlost = nresult%(npeople*won);
                    nresult -= nlost;
                    nresult /=npeople;
                    temp = nlost % won;
                    nlost -= temp;
                    npeople2 = nlost/won;
                    nlost = temp;
                    if(nlost == 0){ npeople -= npeople2; }
                    else{ npeople -= npeople2+1; }
                    if(nresult != 0) {
                        if (npeople2 != 0) { whiletext.setText(npeople2 + "명 : " + (nresult + won) + "원\n"); }
                        if (nlost != 0) { whiletext.setText(whiletext.getText().toString() + "1명 : " + (nresult + nlost) + "원\n"); }
                        if (npeople != 0) { whiletext.setText(whiletext.getText().toString() + npeople + "명 : " + nresult + "원\n"); }
                    }
                    else { Toast.makeText(view.getContext(), won+"원 단위로 나누기에 인원이 너무 많습니다.", Toast.LENGTH_SHORT).show(); }
                }
                else { Toast.makeText(view.getContext(), "총액과 총원을 입력해주세요.", Toast.LENGTH_SHORT).show(); }
            }
        });
        view.findViewById(R.id.won100).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int won = 100;
                int temp, nresult, nlost, npeople, npeople2;
                if(totaltext.getText().toString().equals("0") || peopletext.getText().toString().equals("0")){
                    Toast.makeText(view.getContext(), "0은 입력하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!totaltext.getText().toString().equals("") && !peopletext.getText().toString().equals("")) {
                    whiletext.setText("");
                    nresult = Integer.parseInt(totaltext.getText().toString());
                    npeople = Integer.parseInt(peopletext.getText().toString());
                    nlost = nresult%(npeople*won);
                    nresult -= nlost;
                    nresult /=npeople;
                    temp = nlost % won;
                    nlost -= temp;
                    npeople2 = nlost/won;
                    nlost = temp;
                    if(nlost == 0){ npeople -= npeople2; }
                    else{ npeople -= npeople2+1; }
                    if(nresult != 0) {
                        if (npeople2 != 0) { whiletext.setText(npeople2 + "명 : " + (nresult + won) + "원\n"); }
                        if (nlost != 0) { whiletext.setText(whiletext.getText().toString() + "1명 : " + (nresult + nlost) + "원\n"); }
                        if (npeople != 0) { whiletext.setText(whiletext.getText().toString() + npeople + "명 : " + nresult + "원\n"); }
                    }
                    else { Toast.makeText(view.getContext(), won+"원 단위로 나누기에 인원이 너무 많습니다.", Toast.LENGTH_SHORT).show(); }
                }
                else { Toast.makeText(view.getContext(), "총액과 총원을 입력해주세요.", Toast.LENGTH_SHORT).show(); }
            }
        });
        view.findViewById(R.id.won1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int won = 1;
                int temp, nresult, nlost, npeople, npeople2;
                if(totaltext.getText().toString().equals("0") || peopletext.getText().toString().equals("0")){
                    Toast.makeText(view.getContext(), "0은 입력하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!totaltext.getText().toString().equals("") && !peopletext.getText().toString().equals("")) {
                    whiletext.setText("");
                    nresult = Integer.parseInt(totaltext.getText().toString());
                    npeople = Integer.parseInt(peopletext.getText().toString());
                    nlost = nresult%(npeople*won);
                    nresult -= nlost;
                    nresult /=npeople;
                    temp = nlost % won;
                    nlost -= temp;
                    npeople2 = nlost/won;
                    nlost = temp;
                    if(nlost == 0){ npeople -= npeople2; }
                    else{ npeople -= npeople2+1; }
                    if(nresult != 0) {
                        if (npeople2 != 0) { whiletext.setText(npeople2 + "명 : " + (nresult + won) + "원\n"); }
                        if (nlost != 0) { whiletext.setText(whiletext.getText().toString() + "1명 : " + (nresult + nlost) + "원\n"); }
                        if (npeople != 0) { whiletext.setText(whiletext.getText().toString() + npeople + "명 : " + nresult + "원\n"); }
                    }
                    else { Toast.makeText(view.getContext(), won+"원 단위로 나누기에 인원이 너무 많습니다.", Toast.LENGTH_SHORT).show(); }
                }
                else { Toast.makeText(view.getContext(), "총액과 총원을 입력해주세요.", Toast.LENGTH_SHORT).show(); }
            }
        });
        return view;
    }
}
