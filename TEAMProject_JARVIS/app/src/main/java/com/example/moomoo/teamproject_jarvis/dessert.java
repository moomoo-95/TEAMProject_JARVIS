package com.example.moomoo.teamproject_jarvis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dessert extends AppCompatActivity {
    String dessertlist[] = {
            "아이스 아메리카노", "소프트콘", "블루베리 헤븐(스무디킹)", "녹차프라프치노(스타벅스)", "밀크쉐이크",
            "오레오 맥플러리(맥도날드)", "딸기 딥 초코 티라미슈 설빙", "타로밀크티(공차)", "슈팅스타(베라)", "와플",
            "과일", "군고구마", "붕어빵", "호떡", "프레즐",
            "티라미슈", "초코에몽", "마카롱", "델리만쥬", "소떡소떡(버억)",
            "츄러스", "국화빵", "타코야끼", "갈비만두(중통)", "아이스 헤이즐넛",
            "딸바(쥬씨)", "초바(쥬씨)", "아이스티 복숭아맛", "순대", "아초(종합관)",
            "파인샤베트(동야)", "소프트 아이스크림(종합관)", "후카", "올 때 메로나", "바나나맛우유",
            "닭꼬치", "모짜렐라 IN THE 핫도그(명량)", "맥주", "회오리감자", "떡꼬치"
    };
    service_random_dessert mService;
    boolean mBound = false;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        textView = (TextView)findViewById(R.id.dessertbox);
        Button btn = (Button)findViewById(R.id.dessertbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound){
                    startService(new Intent(dessert.this, service_voice_check.class));
                    int num = mService.getRandomDessert();
                    textView.setText(dessertlist[num]+" 어떠신가요?");
                }
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Intent intent = new Intent(this, service_random_dessert.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
    protected void onStop(){
        super.onStop();
        if(mBound){
            unbindService(mConnection);
            mBound = false;
        }
    }
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            service_random_dessert.dessert_Binder binder = (service_random_dessert.dessert_Binder) service;
            mService = binder.getService();
            mBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
}
