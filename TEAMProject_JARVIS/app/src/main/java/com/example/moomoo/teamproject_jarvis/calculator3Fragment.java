package com.example.moomoo.teamproject_jarvis;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class calculator3Fragment extends Fragment {
    TextView text3, whiletext;
    EditText totaltext, peopletext;
    RadioButton timebtn;
    CheckBox tax, bohum;

    public calculator3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View maview = inflater.inflate(R.layout.fragment_calculator3, container, false);
        text3 = (TextView)maview.findViewById(R.id.threetext3);
        whiletext = (TextView)maview.findViewById(R.id.whiletext3);
        totaltext = (EditText) maview.findViewById(R.id.totalcoin3);
        peopletext = (EditText) maview.findViewById(R.id.nbbangpeople3);
        timebtn = (RadioButton) maview.findViewById(R.id.parttime);
        tax = (CheckBox) maview.findViewById(R.id.getmoney3);
        bohum = (CheckBox) maview.findViewById(R.id.getbohum3);
        maview.findViewById(R.id.parttime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text3.setVisibility(View.VISIBLE);
                peopletext.setVisibility(View.VISIBLE);
            }
        });
        maview.findViewById(R.id.partmonth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text3.setVisibility(View.GONE);
                peopletext.setVisibility(View.GONE);
            }
        });
        maview.findViewById(R.id.moneycal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int money, ptime, totalmoney;
                int taxmoney = 0, yearbo = 0, healthbo = 0, hirebo = 0, compbo = 0;
                String temp;
                if(timebtn.isChecked()){
                    if(totaltext.getText().toString().equals("0") || peopletext.getText().toString().equals("0")){
                        Toast.makeText(maview.getContext(), "0은 입력하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else if(totaltext.getText().toString().equals("") || peopletext.getText().toString().equals("")){
                        Toast.makeText(maview.getContext(), "시급과 근무시간을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        whiletext.setText("");
                        money = Integer.parseInt(totaltext.getText().toString());
                        ptime = Integer.parseInt(peopletext.getText().toString());
                        totalmoney = money * ptime;
                        temp = "월급 : " + totalmoney + "원\n";
                        if(tax.isChecked()){
                            taxmoney = (totalmoney*6)%100;
                            taxmoney = totalmoney - taxmoney;
                            taxmoney = (taxmoney*6)/100;
                            temp = temp + "소득세 : " + taxmoney + "원\n";
                        }
                        if(bohum.isChecked()){
                            yearbo = (totalmoney*45)%1000;
                            yearbo = totalmoney - yearbo;
                            yearbo = (yearbo*45)/1000;
                            healthbo = (totalmoney*323)%10000;
                            healthbo = totalmoney - healthbo;
                            healthbo = (healthbo*323)/10000;
                            hirebo = (totalmoney*65)%10000;
                            hirebo = totalmoney - hirebo;
                            hirebo = (hirebo*65)/10000;
                            compbo = (totalmoney*2)%100;
                            compbo = totalmoney - compbo;
                            compbo = (compbo*2)/100;
                            temp = temp + "연금보험료 : " + yearbo + "원\n"
                                    + "건강보험료 : " + healthbo + "원\n"
                                    + "고용보험료 : " + hirebo + "원\n"
                                    + "산재보험료 : " + compbo + "원\n";
                        }
                        temp = temp + "실수령액 : " + (totalmoney - taxmoney - yearbo - healthbo - hirebo - compbo) + "원\n"
                                +"*세금은 변동될 수 있으므로 \n참고용으로 이용하시기 바랍니다.\n";
                        whiletext.setText(temp);
                    }
                }
                else{
                    if(totaltext.getText().toString().equals("0")){
                        Toast.makeText(maview.getContext(), "0은 입력하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else if(totaltext.getText().toString().equals("")){
                        Toast.makeText(maview.getContext(), "월급을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        whiletext.setText("");
                        money = Integer.parseInt(totaltext.getText().toString());
                        totalmoney = money;
                        temp = "월급 : " + totalmoney + "원\n";
                        if(tax.isChecked()){
                            taxmoney = (totalmoney*6)%100;
                            taxmoney = totalmoney - taxmoney;
                            taxmoney = (taxmoney*6)/100;
                            temp = temp + "소득세 : " + taxmoney + "원\n";
                        }
                        if(bohum.isChecked()){
                            yearbo = (totalmoney*45)%1000;
                            yearbo = totalmoney - yearbo;
                            yearbo = (yearbo*45)/1000;
                            healthbo = (totalmoney*323)%10000;
                            healthbo = totalmoney - healthbo;
                            healthbo = (healthbo*323)/10000;
                            hirebo = (totalmoney*65)%10000;
                            hirebo = totalmoney - hirebo;
                            hirebo = (hirebo*65)/10000;
                            compbo = (totalmoney*2)%100;
                            compbo = totalmoney - compbo;
                            compbo = (compbo*2)/100;
                            temp = temp + "연금보험료 : " + yearbo + "원\n"
                                    + "건강보험료 : " + healthbo + "원\n"
                                    + "고용보험료 : " + hirebo + "원\n"
                                    + "산재보험료 : " + compbo + "원\n";
                        }
                        temp = temp + "실수령액 : " + (totalmoney - taxmoney - yearbo - healthbo - hirebo - compbo) + "원\n"
                                +"*세금은 변동될 수 있으므로 \n참고용으로 이용하시기 바랍니다.\n";
                        whiletext.setText(temp);
                    }

                }
            }
        });

        return maview;
    }
}
