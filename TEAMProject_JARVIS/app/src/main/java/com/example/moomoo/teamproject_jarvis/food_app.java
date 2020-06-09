package com.example.moomoo.teamproject_jarvis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class food_app extends AppCompatActivity {
    String foodname[] = {
            "불고기", "스테이크", "찜닭", "닭볶음탕", "월남쌈", "수육", "아귀찜", "돈까스", "족발",
            "된장찌개", "김치찌개", "부대찌개", "순두부찌개", "마라탕", "동태찌개", "곱창", "고추장찌개", "밀푀유나베",
            "카레", "비빔밥", "오므라이스", "김치볶음밥", "제육덮밥", "사케동", "치킨마요덮밥", "규카츠", "간장계란밥",
            "라멘", "토마토파스타", "크림파스타", "물냉면", "잔치국수", "비빔냉면", "칼국수", "우동", "콩국수",
            "육개장", "닭개장", "치킨", "규동", "매운탕", "갈비탕", "추어탕", "삼계탕", "회",
            "샌드위치", "토스트", "떡볶이", "시리얼", "샐러드", "밥버거", "핫도그", "편의점도시락", "김밥",
            "유부초밥", "초밥", "짜장면", "짬뽕", "깐풍기", "잡채", "마파두부", "팟타이", "쌀국수",
            "햄버거", "순대국", "콩나물국밥", "부타동", "양꼬치", "뼈해장국", "해장라면", "오코노미야끼", "피자"
    };
    String foodtype[] = { "간편식", "고기", "국/탕", "찌개", "밥", "면", " 해장" };
    String foodnation[] = { "동남아음식", "한식", "일식", "중식", "양식" };
    String foodfavor[] = {"매콤","달달","보통","느끼"};
    String foodmain[] = {"소고기","돼지고기","닭고기","양고기","해물","밀가루","쌀", "야채"};
    Button yes, no, dont, re;
    TextView message;
    int chnext = 0;
    int next = 1;
    class food{
        String name, type, nation, flavor, main;
        boolean tempo, solo;
        int speed;
        boolean choice = true;
        boolean last = true;
        public food(String na, String ty, String nat, boolean te, int sp, String fl, boolean so, String  ma){
            name = na; type = ty; nation = nat; tempo = te; speed = sp; flavor = fl; solo = so; main = ma;
        }
    }
    food choicefood[] = new food[72];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        yes = (Button)findViewById(R.id.yesbtn);
        no = (Button)findViewById(R.id.nobtn);
        dont = (Button)findViewById(R.id.dontknowbtn);
        re = (Button)findViewById(R.id.restartbtn);
        message = (TextView)findViewById(R.id.textbox);

        choicefood[0] = new food(foodname[0], foodtype[1], foodnation[1], true, 3, foodfavor[1], false, foodmain[0]);
        choicefood[1] = new food(foodname[1], foodtype[1], foodnation[4], true, 3, foodfavor[1], false, foodmain[0]);
        choicefood[2] = new food(foodname[2], foodtype[1], foodnation[1], true, 3, foodfavor[1], false, foodmain[2]);
        choicefood[3] = new food(foodname[3], foodtype[1], foodnation[1], true, 3, foodfavor[0], false, foodmain[2]);
        choicefood[4] = new food(foodname[4], foodtype[1], foodnation[0], true, 3, foodfavor[2], false, foodmain[0]);
        choicefood[5] = new food(foodname[5], foodtype[1], foodnation[1], true, 3, foodfavor[2], false, foodmain[1]);
        choicefood[6] = new food(foodname[6], foodtype[1], foodnation[1], true, 3, foodfavor[0], false, foodmain[4]);
        choicefood[7] = new food(foodname[7], foodtype[1], foodnation[2], true, 3, foodfavor[1], true, foodmain[1]);
        choicefood[8] = new food(foodname[8], foodtype[1], foodnation[1], true, 3, foodfavor[1], false, foodmain[1]);

        choicefood[9] = new food(foodname[9], foodtype[3], foodnation[1], true, 3, foodfavor[0], false, foodmain[1]);
        choicefood[10] = new food(foodname[10], foodtype[3], foodnation[1], true, 3, foodfavor[0], false, foodmain[1]);
        choicefood[11] = new food(foodname[11], foodtype[3], foodnation[1], true, 3, foodfavor[0], false, foodmain[1]);
        choicefood[12] = new food(foodname[12], foodtype[3], foodnation[1], true, 3, foodfavor[0], false, foodmain[1]);
        choicefood[13] = new food(foodname[13], foodtype[2], foodnation[3], true, 1, foodfavor[0], true, foodmain[3]);
        choicefood[14] = new food(foodname[14], foodtype[3], foodnation[1], true, 3, foodfavor[0], false, foodmain[4]);
        choicefood[15] = new food(foodname[15], foodtype[1], foodnation[1], true, 3, foodfavor[1], false, foodmain[0]);
        choicefood[16] = new food(foodname[16], foodtype[3], foodnation[1], true, 3, foodfavor[0], true, foodmain[1]);
        choicefood[17] = new food(foodname[17], foodtype[3], foodnation[2], true, 3, foodfavor[1], false, foodmain[0]);

        choicefood[18] = new food(foodname[18], foodtype[4], foodnation[1], true, 2, foodfavor[0], true, foodmain[6]);
        choicefood[19] = new food(foodname[19], foodtype[4], foodnation[1], true, 2, foodfavor[0], true, foodmain[6]);
        choicefood[20] = new food(foodname[20], foodtype[4], foodnation[2], true, 2, foodfavor[1], true, foodmain[6]);
        choicefood[21] = new food(foodname[21], foodtype[4], foodnation[1], true, 2, foodfavor[2], true, foodmain[6]);
        choicefood[22] = new food(foodname[22], foodtype[4], foodnation[1], true, 2, foodfavor[2], true, foodmain[1]);
        choicefood[23] = new food(foodname[23], foodtype[4], foodnation[2], true, 2, foodfavor[1], true, foodmain[4]);
        choicefood[24] = new food(foodname[24], foodtype[4], foodnation[1], true, 2, foodfavor[1], true, foodmain[2]);
        choicefood[25] = new food(foodname[25], foodtype[1], foodnation[2], true, 2, foodfavor[1], true, foodmain[0]);
        choicefood[26] = new food(foodname[26], foodtype[4], foodnation[1], true, 2, foodfavor[1], true, foodmain[6]);

        choicefood[27] = new food(foodname[27], foodtype[5], foodnation[2], true, 2, foodfavor[3], false, foodmain[5]);
        choicefood[28] = new food(foodname[28], foodtype[5], foodnation[4], true, 2, foodfavor[3], false, foodmain[5]);
        choicefood[29] = new food(foodname[29], foodtype[5], foodnation[4], true, 2, foodfavor[3], false, foodmain[5]);
        choicefood[30] = new food(foodname[30], foodtype[5], foodnation[1], false, 2, foodfavor[2], true, foodmain[5]);
        choicefood[31] = new food(foodname[31], foodtype[5], foodnation[1], true, 2, foodfavor[2], true, foodmain[5]);
        choicefood[32] = new food(foodname[32], foodtype[5], foodnation[1], false, 2, foodfavor[0], true, foodmain[5]);
        choicefood[33] = new food(foodname[33], foodtype[5], foodnation[1], true, 2, foodfavor[2], true, foodmain[5]);
        choicefood[34] = new food(foodname[34], foodtype[5], foodnation[2], true, 2, foodfavor[3], true, foodmain[5]);
        choicefood[35] = new food(foodname[35], foodtype[5], foodnation[1], false, 2, foodfavor[2], true, foodmain[5]);

        choicefood[36] = new food(foodname[36], foodtype[2], foodnation[1], true, 2, foodfavor[0], true, foodmain[0]);
        choicefood[37] = new food(foodname[37], foodtype[1], foodnation[1], true, 1, foodfavor[2], false, foodmain[4]);
        choicefood[38] = new food(foodname[38], foodtype[1], foodnation[1], true, 2, foodfavor[3], false, foodmain[2]);
        choicefood[39] = new food(foodname[39], foodtype[4], foodnation[2], true, 2, foodfavor[1], true, foodmain[0]);
        choicefood[40] = new food(foodname[40], foodtype[2], foodnation[1], true, 3, foodfavor[0], false, foodmain[4]);
        choicefood[41] = new food(foodname[41], foodtype[2], foodnation[1], true, 3, foodfavor[1], false, foodmain[0]);
        choicefood[42] = new food(foodname[42], foodtype[2], foodnation[1], true, 3, foodfavor[0], false, foodmain[4]);
        choicefood[43] = new food(foodname[43], foodtype[2], foodnation[1], true, 3, foodfavor[2], false, foodmain[2]);
        choicefood[44] = new food(foodname[44], foodtype[1], foodnation[2], false, 2, foodfavor[2], false, foodmain[4]);

        choicefood[45] = new food(foodname[45], foodtype[0], foodnation[4], true, 1, foodfavor[1], true, foodmain[5]);
        choicefood[46] = new food(foodname[46], foodtype[0], foodnation[4], true, 1, foodfavor[1], true, foodmain[5]);
        choicefood[47] = new food(foodname[47], foodtype[0], foodnation[1], true, 1, foodfavor[0], true, foodmain[6]);
        choicefood[48] = new food(foodname[48], foodtype[0], foodnation[4], false, 1, foodfavor[1], true, foodmain[5]);
        choicefood[49] = new food(foodname[49], foodtype[0], foodnation[4], false, 1, foodfavor[2], true, foodmain[7]);
        choicefood[50] = new food(foodname[50], foodtype[0], foodnation[1], true, 1, foodfavor[2], true, foodmain[6]);
        choicefood[51] = new food(foodname[51], foodtype[0], foodnation[4], true, 1, foodfavor[1], true, foodmain[5]);
        choicefood[52] = new food(foodname[52], foodtype[0], foodnation[1], true, 1, foodfavor[2], true, foodmain[6]);
        choicefood[53] = new food(foodname[53], foodtype[0], foodnation[1], true, 1, foodfavor[2], true, foodmain[6]);

        choicefood[54] = new food(foodname[54], foodtype[0], foodnation[1], true, 1, foodfavor[2], true, foodmain[6]);
        choicefood[55] = new food(foodname[55], foodtype[0], foodnation[2], true, 1, foodfavor[2], true, foodmain[6]);
        choicefood[56] = new food(foodname[56], foodtype[5], foodnation[2], true, 2, foodfavor[1], true, foodmain[4]);
        choicefood[57] = new food(foodname[57], foodtype[5], foodnation[3], true, 2, foodfavor[3], true, foodmain[5]);
        choicefood[58] = new food(foodname[58], foodtype[1], foodnation[3], true, 2, foodfavor[0], true, foodmain[5]);
        choicefood[59] = new food(foodname[59], foodtype[5], foodnation[3], true, 2, foodfavor[3], false, foodmain[2]);
        choicefood[60] = new food(foodname[60], foodtype[4], foodnation[1], true, 2, foodfavor[3], false, foodmain[5]);
        choicefood[61] = new food(foodname[61], foodtype[5], foodnation[3], true, 2, foodfavor[0], false, foodmain[1]);
        choicefood[62] = new food(foodname[62], foodtype[5], foodnation[0], true, 2, foodfavor[0], false, foodmain[6]);

        choicefood[63] = new food(foodname[63], foodtype[1], foodnation[4], true, 1, foodfavor[1], true, foodmain[5]);
        choicefood[64] = new food(foodname[64], foodtype[6], foodnation[1], true, 2, foodfavor[2], true, foodmain[1]);
        choicefood[65] = new food(foodname[65], foodtype[6], foodnation[1], true, 2, foodfavor[2], true, foodmain[7]);
        choicefood[66] = new food(foodname[66], foodtype[4], foodnation[2], true, 2, foodfavor[1], true, foodmain[1]);
        choicefood[67] = new food(foodname[67], foodtype[1], foodnation[3], true, 2, foodfavor[2], false, foodmain[3]);
        choicefood[68] = new food(foodname[68], foodtype[6], foodnation[1], true, 2, foodfavor[2], true, foodmain[1]);
        choicefood[69] = new food(foodname[69], foodtype[6], foodnation[1], true, 2, foodfavor[0], true, foodmain[5]);
        choicefood[70] = new food(foodname[70], foodtype[1], foodnation[2], true, 2, foodfavor[3], false, foodmain[4]);
        choicefood[71] = new food(foodname[71], foodtype[0], foodnation[4], true, 3, foodfavor[3], false, foodmain[5]);
    }
    public void choice(View view){
        int u = 0;
        switch (view.getId()){
            case R.id.yesbtn:
                startService(new Intent(this, service_voice_check.class));
                if(next == 1){
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].speed == 1 ){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    next++;
                    message.setText("동남아음식 좋아하세요?");
                }
                else if(next == 2) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].nation != foodnation[chnext] ){ choicefood[k].choice = false;}
                    }
                    chnext = 0;
                    next++;
                    message.setText("지금 많이 더우신가요?");
                }
                else if(next == 3) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].tempo == true ){ choicefood[k].choice = false;}
                    }
                    message.setText("어제 술을 드셨나요?");
                    next++;
                }
                else if(next == 4) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].type != foodtype[6] ){ choicefood[k].choice = false;}
                    }
                    message.setText("면 좋아하시나요?");
                    next++;
                }
                else if(next == 5) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].type != foodtype[5] ){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    message.setText("혼자 드시나요?");
                    next++;
                }
                else if(next == 6) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].solo == false ){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    next++;
                    message.setText("매운거 좋아하세요?");
                }
                else if(next == 7) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].flavor != foodfavor[3]){ choicefood[k].choice = false;
                        }
                    }
                    next++;
                    message.setText("느끼한거 좋아하세요?");
                }
                else if(next == 8) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].flavor != foodfavor[0]){ choicefood[k].choice = false;
                        }
                    }
                    next++;
                    message.setText(foodmain[chnext] + " 요리 좋아하세요?");
                }
                else if(next == 9) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].main != foodmain[chnext] ){ choicefood[k].choice = false;}
                    }
                    chnext = 0;
                    next++;
                }
                break;
            case R.id.nobtn:
                startService(new Intent(this, service_voice_afraid.class));
                if(next == 1){
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].speed > 1 ){ choicefood[k].choice = false;
                            choicefood[k].last = false;}
                    }
                    next++;
                    message.setText("동남아음식 좋아하세요?");
                }
                else if(next == 2) {
                    for (int k = 0; k < 72; k++) {
                        if (choicefood[k].nation == foodnation[chnext]) {
                            choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    if(chnext == 4){ chnext = 0; next++;
                        message.setText("지금 많이 더우신가요?"); break;
                    }
                    else {
                        chnext++;
                        message.setText(foodnation[chnext] + "음식 좋아하세요?");
                    }
                }
                else if(next == 3) {
                    for (int k = 0; k < 72; k++) {
                        if (choicefood[k].tempo != true) {
                            choicefood[k].choice = false;
                        }
                    }
                    message.setText("어제 술을 드셨나요?");
                    next++;
                }
                else if(next == 4) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].type == foodtype[6] ){ choicefood[k].choice = false;
                            choicefood[k].last = false;}
                    }
                    message.setText("면 좋아하시나요?");
                    next++;
                }
                else if(next == 5) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].type == foodtype[5] ){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    message.setText("혼자 드시나요?");
                    next++;
                }
                else if(next == 6) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].solo == true ){ choicefood[k].choice = false;
                        }
                    }
                    next++;
                    message.setText("매운거 좋아하세요?");
                }
                else if(next == 7) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].flavor == foodfavor[0]){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    next++;
                    message.setText("느끼한거 좋아하세요?");
                }
                else if(next == 8) {
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].flavor == foodfavor[3]){ choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    next++;
                    message.setText(foodmain[chnext] + " 요리 좋아하세요?");
                }
                else if(next == 9) {
                    for (int k = 0; k < 72; k++) {
                        if (choicefood[k].main == foodmain[chnext]) {
                            choicefood[k].choice = false;
                            choicefood[k].last = false;
                        }
                    }
                    if(chnext == 8){ chnext = 0; next++;
                        break;
                    }
                    else {
                        chnext++;
                        message.setText(foodmain[chnext] + " 요리 좋아하세요?");
                    }
                }
                break;
            case R.id.dontknowbtn:
                startService(new Intent(this, service_voice_data.class));
                if(next == 1){
                    for(int k = 0; k < 72; k++){
                        if(choicefood[k].speed > 2 ){ choicefood[k].choice = false; }
                    }
                    next++;
                    message.setText("동남아음식 좋아하세요?");
                }
                else if(next == 2){
                    if(chnext == 4){ chnext = 0; next++;
                        message.setText("지금 많이 더우신가요?");break;
                    }
                    else {
                        chnext++;
                        message.setText(foodnation[chnext] + "음식 좋아하세요?");
                    }
                }
                else if(next == 3) {
                    next++;
                    message.setText("어제 술을 드셨나요?");
                }
                else if(next == 4) {
                    next++;
                    message.setText("면 좋아하시나요?");
                }
                else if(next == 5) {
                    next++;
                    message.setText("혼자 드시나요?");
                }
                else if(next == 6) {
                    next++;
                    message.setText("매운거 좋아하세요?");
                }
                else if(next == 7) {
                    next++;
                    message.setText("느끼한거 좋아하세요?");
                }
                else if(next == 8) {
                    next++;
                    message.setText(foodmain[chnext] + " 요리 좋아하세요?");
                }
                else if(next == 9){
                    if(chnext == 8){ chnext = 0; next++;
                        break;
                    }
                    else {
                        chnext++;
                        message.setText(foodmain[chnext] + " 요리 좋아하세요?");
                    }
                }
                break;
            case R.id.restartbtn:
                startService(new Intent(this, service_voice_service.class));
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                dont.setVisibility(View.VISIBLE);
                next = 1;
                chnext = 0;
                message.setText("식사를 할 수 있는 시간이 많으신가요?");
                u = 1;
                break;
        }
        if(u == 1) {
            re.setVisibility(View.GONE);
        }
        result();
    }
    private void result(){
        int count = 0;
        String temp = "";
        for(int k = 0; k < 72; k++){
            if(choicefood[k].choice == true){ count++; temp = choicefood[k].name +", "+temp; }
        }
        if(count == 0){
            for(int k = 0; k < 72; k++){
                if(choicefood[k].last == true){choicefood[k].choice = true; }
            }
        }
        else if(count <= 3){
            startService(new Intent(this, service_voice_congratulation.class));
            next = 0;
            message.setText("제가 오늘 추천할 음식은 "+temp+" 입니다^^");
            yes.setVisibility(View.GONE);
            no.setVisibility(View.GONE);
            dont.setVisibility(View.GONE);
            re.setVisibility(View.VISIBLE);
            for(int k = 0; k < 72; k++){
                choicefood[k].choice = true;
                choicefood[k].last = true;
            }
        }
        if(next >= 10){
            startService(new Intent(this, service_voice_congratulation.class));
            if(count == 0){
                message.setText("오늘 쫌 까다로우시네요... 굶으시는게 좋을 것같네요");
            }
            else {
                message.setText("제가 오늘 추천할 음식은 "+temp+" 입니다.^^");
            }
            next = 0;
            yes.setVisibility(View.GONE);
            no.setVisibility(View.GONE);
            dont.setVisibility(View.GONE);
            re.setVisibility(View.VISIBLE);
            for(int k = 0; k < 72; k++){
                choicefood[k].choice = true;
                choicefood[k].last = true;
            }
        }
    }
}
