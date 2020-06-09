package com.example.moomoo.teamproject_jarvis;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class simpletodo_sub extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpletodo_sub);

        editText = (EditText) findViewById(R.id.to_do);
        button = (Button) findViewById(R.id.to_do_date);


    }

    public void add_date(View view) {
        final Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH)+1;
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                button.setText(year + "년 " + month + "월 "+ dayOfMonth +"일 ");
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void done(View view) {

        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT", editText.getText().toString());
        intent.putExtra("INPUT_TEXT1", button.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }


}
