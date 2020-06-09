package com.example.moomoo.teamproject_jarvis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class drunk extends AppCompatActivity {
    String food[] = {
            "치킨", "감자튀김", "마른안주", "육포", "양꼬치",
            "오꼬노미야끼", "새우구이", "소세지", "피자", "탕수육",

            "족발", "닭발", "감자탕", "삼겹살", "곱창/막창",
            "연어사시미", "육회", "짬뽕", "생선회", "조개구이",
            "꼼장어", "매운탕", "동파육", "어묵탕", "계란말이",

            "삼겹살", "술국", "해물찜", "육회", "막창",
            "생선회", "골뱅이소면", "닭갈비", "제육볶음", "곱창",

            "짜파게티", "나쵸", "생선회", "로제파스타", "초콜렛",
            "케이크", "치즈", "청포도", "스테이크", "크림파스타",

            "떡볶이", "생선회", "분위기", "레몬", "소금",
            "토닉워터", "오렌지쥬스", "치즈", "감자", "과일",

            "꼬치구이", "오꼬노미야끼", "연어사시미", "타코야끼", "메로구이",
            "우동", "나가사키짬뽕", "새우튀김", "볶음우동", "타코와사비",

            "김치전", "감자전", "부추전", "해물파전", "두부김치",
            "메밀묵", "오징어순대", "녹두전", "빈대떡", "오꼬노미야끼",

            "치즈", "과일", "마카롱", "피자", "나쵸",
            "까나페", "초코칩", "아보카도", "분위기", "후카"
    };
    int point = 0;
    Random random = new Random();
    TextView box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drunk);
        box = (TextView)findViewById(R.id.bestbox);
        Spinner spinner = (Spinner)findViewById(R.id.drunk_spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.drunk_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                point = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Button btn = (Button)findViewById(R.id.bestbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(drunk.this, service_voice_check.class));
                switch (point){
                    case 0:
                        box.setText("오늘은 "+(food[random.nextInt(85)])+"에 술을 드시는게 어떻겠습니까?");
                        break;
                    case 1:
                        box.setText("오늘은 "+ adapter.getItem(1).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)])+"을(를) 추천해드립니다.");
                        break;
                    case 2:
                        box.setText("오늘은 "+ adapter.getItem(2).toString() + "에 어울리는 안주인 "+(food[random.nextInt(15)+10])+"을(를) 추천해드립니다.");
                        break;
                    case 3:
                        box.setText("오늘은 "+ adapter.getItem(3).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+25])+"을(를) 추천해드립니다.");
                        break;
                    case 4:
                        box.setText("오늘은 "+ adapter.getItem(4).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+35])+"을(를) 추천해드립니다.");
                        break;
                    case 5:
                        box.setText("오늘은 "+ adapter.getItem(5).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+45])+"을(를) 추천해드립니다.");
                        break;
                    case 6:
                        box.setText("오늘은 "+ adapter.getItem(6).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+55])+"을(를) 추천해드립니다.");
                        break;
                    case 7:
                        box.setText("오늘은 "+ adapter.getItem(7).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+65])+"을(를) 추천해드립니다.");
                        break;
                    case 8:
                        box.setText("오늘은 "+ adapter.getItem(8).toString() + "에 어울리는 안주인 "+(food[random.nextInt(10)+75])+"을(를) 추천해드립니다.");
                        break;
                }
            }
        });
    }
}
