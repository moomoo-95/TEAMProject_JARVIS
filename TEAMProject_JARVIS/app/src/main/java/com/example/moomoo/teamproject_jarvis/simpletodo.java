package com.example.moomoo.teamproject_jarvis;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class simpletodo extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView etNewItem, etNewCal;
    private slistadapter itemsAdapter;
    private ListView lvItems;
    private ProgressDialog progressDialog;
    boolean notinout = false;
    sdbhelper helper;
    SQLiteDatabase db;
    int count = 0;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpletodo);
        helper = new sdbhelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM scontacts", null);
        etNewItem = (TextView) findViewById(R.id.etNewItem);
        etNewCal=(TextView)findViewById(R.id.etCal);

        itemsAdapter = new slistadapter();
        lvItems = (ListView) findViewById(R.id.lvItems);
        setData();
        notinout = false;
        lvItems.setAdapter(itemsAdapter);
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter2, View item, int pos, long id) {
                        deleteThread();
                        itemsAdapter.removeItem(pos);
                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
    }
    private void setData(){
        scustomitem ex1 = new scustomitem();
        scustomitem ex2 = new scustomitem();
        notinout = true;
        ex1.setItemname("상단 체크 버튼을 눌러 할 일을 작성해요!");
        ex1.setItemtype("설명1");
        itemsAdapter.addItem(ex1);
        ex2.setItemname("길게 누르면 할 일이 없어져요!");
        ex2.setItemtype("설명2");
        itemsAdapter.addItem(ex2);
        while(cursor.moveToNext()==true){
            scustomitem customitem = new scustomitem();
            customitem.setResid(count++);
            customitem.setItemname(cursor.getString(1));
            customitem.setItemtype(cursor.getString(2));
            notinout = true;
            itemsAdapter.addItem(customitem);
        }
    }
    public class scustomitem{
        private  int resid;
        private  String  itemdo, itemdate;
        public int getResid(){
            return  resid;
        }
        public void setResid(int resid){
            this.resid = resid;
        }
        public String getItemname(){
            return itemdo;
        }
        public void setItemname(String itemname){
            this.itemdo = itemname;
        }
        public String getItemtype(){
            return itemdate;
        }
        public void setItemtype(String itemtype){
            this.itemdate = itemtype;
        }
    }
    class slistadapter extends BaseAdapter{
        private ArrayList<scustomitem> listcustom = new ArrayList<>();

        public int getCount(){
            return listcustom.size();
        }
        public scustomitem getItem(int position){
            return listcustom.get(position);
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View view, ViewGroup parent){
            hholder hholderrr;
            if(view == null){
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simpletodo_listitem, null, false);
                hholderrr = new hholder();
                hholderrr.hodo = (TextView) view.findViewById(R.id.todolistDo);
                hholderrr.hodate = (TextView) view.findViewById(R.id.todolistDate);
                view.setTag(hholderrr);
            }
            else{
                hholderrr = (hholder) view.getTag();
            }
            scustomitem item = listcustom.get(position);
            hholderrr.hodo.setTextColor(Color.WHITE);
            hholderrr.hodate.setTextColor(Color.WHITE);
            hholderrr.hodo.setText(item.getItemname());
            hholderrr.hodate.setText(item.getItemtype());
            return view;
        }
        public void addItem(scustomitem item){
            listcustom.add(item);
            if(notinout == false) {
                db.execSQL("INSERT INTO scontacts VALUES (null, '" + item.getItemname() + "', '" + item.getItemtype() + "');");
            }
        }
        public void removeItem(int i){
            scustomitem item = getItem(i);
            listcustom.remove(i);
            db.execSQL("DELETE FROM scontacts WHERE do = '"+item.getItemname()+"' AND date = '"+item.getItemtype()+"';");
        }
        public void reset(){
            listcustom.removeAll(listcustom);
            db.execSQL("DELETE FROM scontacts");
        }
        class hholder{
            TextView hodo, hodate;
        }
    }
    public void onAddItem(View v) {
        if(etNewItem.getText().toString().compareTo("") == 0){
            Toast.makeText(simpletodo.this, "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        else if(etNewCal.getText().toString().compareTo("마감 날짜 선택") == 0){
            Toast.makeText(simpletodo.this, "날짜를 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        else {
            startService(new Intent(this, service_voice_check.class));
            addThread();
            scustomitem item = new scustomitem();
            item.setResid(count++);
            item.setItemname(etNewItem.getText().toString());
            item.setItemtype(etNewCal.getText().toString() + "까지");
            etNewItem.setText("");
            etNewCal.setText("");
            itemsAdapter.addItem(item);
            itemsAdapter.notifyDataSetChanged();
        }

    }

    public void deleteThread() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("삭제 중");
        progressDialog.setMessage("잠시만 기다려 주세요...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
        new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                try {
                    sleep(1500);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    public void addThread() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("추가 중");
        progressDialog.setMessage("잠시만 기다려 주세요...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
        new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                try {
                    sleep(1500);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.simplemenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_add:
                startService(new Intent(this, service_voice_check.class));
                Intent intent = new Intent(simpletodo.this, simpletodo_sub.class);
                startActivityForResult(intent, GET_STRING);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                etNewItem.setText(data.getStringExtra("INPUT_TEXT"));
                etNewCal.setText(data.getStringExtra("INPUT_TEXT1"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    class sdbhelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "todo_contacts.db";
        private static final int DATABASE_VERSION = 3;
        public sdbhelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE scontacts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, do TEXT, date TEXT);");
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS scontacts");
            onCreate(db);
        }
    }


}
