package com.example.moomoo.teamproject_jarvis;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class water_app extends AppCompatActivity {

    NotificationManager notificationManager;
    PendingIntent pendingIntent;
    ImageView imageview;
    NumberPicker numberPicker;
    TextView textView;
    int Num;
    int InputWater;
    int RequireWater = 2000;
    TextView textView1;
    int myear, mmonth, mday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_app);


        final Button btn1 = (Button) findViewById(R.id.wbtn_reset);
        final Button btn2 = (Button) findViewById(R.id.wbtn_noti);
        final LinearLayout backGround = (LinearLayout) findViewById(R.id.linear);


        imageview = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.wresult);
        textView1 = (TextView) findViewById(R.id.hint);
        GregorianCalendar Gcalendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        myear = calendar.get(Calendar.YEAR);
        mmonth = calendar.get(Calendar.MONTH);
        mday = calendar.get(Calendar.DAY_OF_MONTH);
        final ImageView image = (ImageView) findViewById(R.id.wbackimage);
        final ImageView water = (ImageView) findViewById(R.id.waterimage);

        final DBHelper dbHelper1 = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);


        int setting = 0;
        try {
            if (Integer.parseInt(dbHelper1.getResult()) > 0) {
                setting = Integer.parseInt(dbHelper1.getResult());
            }
            RequireWater = setting;
        }catch (Exception e){}


        btn1.setEnabled(true);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //datePickerDialog.show();
                RequireWater = 2000;
                numberPicker.setEnabled(true);
                btn2.setEnabled(true);
                Toast.makeText(getApplicationContext(), "물 마시기 초기화 완료!", Toast.LENGTH_SHORT).show();
                textView.setText("물 마시기 초기화 완료");
                image.setImageDrawable(getResources().getDrawable(R.drawable.dryness));
                image.setAlpha(200);


            }
        });

        numberPicker = (NumberPicker) findViewById(R.id.numpick);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        numberPicker.setBackgroundColor(Color.WHITE);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDisplayedValues(new String[]{"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"});
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Num = numberPicker.getValue();
                InputWater = (Num * 100);

            }
        });


        if (RequireWater <= 0) {
            textView.setText("하루 섭취량 달성 완료!");
            numberPicker.setEnabled(false);
            btn2.setEnabled(false);
            image.setImageDrawable(getResources().getDrawable(R.drawable.waterful));
        } else {
            RequireWater = RequireWater - InputWater;
            textView.setText("현재 남은 섭취량은 " + RequireWater + "mL입니다");
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "입력 완료!", Toast.LENGTH_SHORT).show();

                RequireWater = RequireWater - InputWater;
                textView.setText("현재 남은 섭취량은 " + RequireWater + "mL입니다");
                water.setImageResource(R.drawable.ic_iconmonstr_drop_15);


                if (RequireWater <= 0) {
                    textView.setText("하루 섭취량 달성 완료!");
                    numberPicker.setEnabled(false);
                    btn2.setEnabled(false);
                    // image.setAlpha(0);
                    image.setImageDrawable(getResources().getDrawable(R.drawable.waterful));
                    image.setAlpha(200);
                } else if (RequireWater == 2000) {
                    image.setAlpha(200);
                } else if (RequireWater <= 1500 && RequireWater > 1000) {
                    image.setAlpha(150);
                } else if (RequireWater <= 1000 && RequireWater > 500) {
                    image.setAlpha(100);

                }

                int item = RequireWater;
                dbHelper1.insert(item);
                dbHelper1.update(item);


                createNotification();


            }
        });


    }


    private void createNotification() { // 상태바 알림

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Water Alarm");
        builder.setColor(Color.BLUE);
        builder.setAutoCancel(false);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setOngoing(true);
        if (RequireWater <= 0) {
            builder.setContentText("하루 섭취량 달성 완료!");

        } else {
            builder.setContentText(RequireWater + "mL만큼 물을 마셔야 해요!");
        }

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManager.notify(0, builder.build());


    }

    public class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // DB를 새로 생성할 때 호출되는 함수
        @Override
        public void onCreate(SQLiteDatabase db) {
            // 새로운 테이블 생성

            db.execSQL("CREATE TABLE MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT);");
        }

        // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void insert(int item) {
            // 읽고 쓰기가 가능하게 DB 열기
            SQLiteDatabase db = getWritableDatabase();
            // DB에 입력한 값으로 행 추가
            db.execSQL("INSERT INTO MONEYBOOK VALUES(null, '" + item + "');");
            db.close();
        }

        public void update(int item) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행의 가격 정보 수정
            db.execSQL("UPDATE MONEYBOOK  set item='" + item + "';");
            db.close();
        }

        public void delete(int item) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM MONEYBOOK WHERE item='" + item + "';");
            db.close();
        }

        public String getResult() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            String result = "";

            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK", null);
            while (cursor.moveToNext()) {
                result = cursor.getString(1);
            }

            return result;
        }
    }


}
