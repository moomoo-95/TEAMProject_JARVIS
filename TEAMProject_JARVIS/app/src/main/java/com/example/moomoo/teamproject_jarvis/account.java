package com.example.moomoo.teamproject_jarvis;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class account extends AppCompatActivity {
    int toin = 0, toout = 0, toall = 0;
    TextView tin, tout, tall;
    int count = 0;
    boolean notinout = false;
    private CustomList adapter;
    private ListView list;
    dbhelper helper;
    SQLiteDatabase db;
    Cursor cursor;

    String[] tt = {
            "수입", "지출"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        helper = new dbhelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM contacts", null);
        tin = (TextView) findViewById(R.id.totalin);
        tout = (TextView) findViewById(R.id.totalout);
        tall = (TextView) findViewById(R.id.totalall);
        adapter = new CustomList();
        list = (ListView) findViewById(R.id.account_list);
        setData();
        notinout = false;
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter2, View item, int pos, long id) {
                        adapter.removeItem(pos);
                        adapter.notifyDataSetChanged();
                        return true;
                    }
                });

    }
    private void setData(){
        while(cursor.moveToNext()==true){
            customitem customitem = new customitem();
            customitem.setResid(count++);
            customitem.setItemname(cursor.getString(1));
            customitem.setItemtype(cursor.getString(2));
            customitem.setItemcoin(Integer.parseInt(cursor.getString(3)));
            notinout = true;
            adapter.addItem(customitem);
        }
    }
    public class customitem{
        private  int resid;
        private  String  itemname, itemtype;
        int itemcoin;
        public int getResid(){
            return  resid;
        }
        public void setResid(int resid){
            this.resid = resid;
        }
        public String getItemname(){
            return itemname;
        }
        public void setItemname(String itemname){
            this.itemname = itemname;
        }
        public String getItemtype(){
            return itemtype;
        }
        public void setItemtype(String itemtype){
            this.itemtype = itemtype;
        }
        public int getItemcoin(){
            return itemcoin;
        }
        public void setItemcoin(int itemcoin){
            this.itemcoin = itemcoin;
        }
    }
    public class CustomList extends BaseAdapter {
        private ArrayList<customitem> listcustom = new ArrayList<>();

        public int getCount(){
            return listcustom.size();
        }
        public customitem getItem(int position){
            return listcustom.get(position);
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View view, ViewGroup parent){
            hholder hholderrr;
            if(view == null){
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_listitem, null, false);
                hholderrr = new hholder();
                hholderrr.honame = (TextView) view.findViewById(R.id.count_name);
                hholderrr.hotype = (TextView) view.findViewById(R.id.count_type);
                hholderrr.hocoin = (TextView) view.findViewById(R.id.count_coin);
                view.setTag(hholderrr);
            }
            else{
                hholderrr = (hholder) view.getTag();
            }
            customitem item = listcustom.get(position);
            if(item.getItemtype().equals("수입")){
                hholderrr.honame.setTextColor(Color.BLUE);
                hholderrr.hotype.setTextColor(Color.BLUE);
                hholderrr.hocoin.setTextColor(Color.BLUE);
            }
            else{
                hholderrr.honame.setTextColor(Color.RED);
                hholderrr.hotype.setTextColor(Color.RED);
                hholderrr.hocoin.setTextColor(Color.RED);
            }
            hholderrr.honame.setText(item.getItemname());
            hholderrr.hotype.setText(item.getItemtype());
            hholderrr.hocoin.setText(item.getItemcoin()+"원");
            return view;
        }
        public void addItem(customitem item){
            if(item.getItemtype().equals("수입")){
                toin += item.getItemcoin();
                tin.setText(toin+"원");
            }
            else{
                toout += item.getItemcoin();
                tout.setText(toout+"원");
            }
            toall = toin - toout;
            tall.setText(toall+"원");
            listcustom.add(item);
            if(notinout == false) {
                db.execSQL("INSERT INTO contacts VALUES (null, '" + item.getItemname() + "', '" + item.getItemtype() + "', '" + String.valueOf(item.getItemcoin()) + "');");
            }
        }
        public void removeItem(int i){
            customitem item = getItem(i);
            if(item.getItemtype().equals("수입")){
                toin -= item.getItemcoin();
                tin.setText(toin+"원");
            }
            else{
                toout -= item.getItemcoin();
                tout.setText(toout+"원");
            }
            toall = toin - toout;
            tall.setText(toall+"원");
            listcustom.remove(i);
            db.execSQL("DELETE FROM contacts WHERE name = '"+item.getItemname()+"' AND (type = '"+item.getItemtype()+"' AND coin = '"+String.valueOf(item.getItemcoin())+"')");
        }
        public void reset(){
            toin = 0;
            tin.setText(toin+"원");
            toout = 0;
            tout.setText(toout+"원");
            toall = 0;
            tall.setText(toall+"원");
            listcustom.removeAll(listcustom);
            db.execSQL("DELETE FROM contacts");
        }
        class hholder{
            TextView honame, hotype, hocoin;
        }

    }
    public void account_click(View v){
        CustomDialog customDialog = new CustomDialog(account.this);
        switch (v.getId()){
            case R.id.account_add:
                startService(new Intent(this, service_voice_check.class));
                customDialog.callFunction();
                break;
            case R.id.account_reset:
                startService(new Intent(this, service_voice_afraid.class));
                adapter.reset();
                break;
        }
    }
    public class CustomDialog {
        private Context context;
        public CustomDialog(Context context) {
            this.context = context;
        }

        public void callFunction() {
            final Dialog dlg = new Dialog(context);
            dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dlg.setContentView(R.layout.account_dialog);
            dlg.show();
            final EditText name = (EditText) dlg.findViewById(R.id.count_subname);
            final EditText coin = (EditText) dlg.findViewById(R.id.count_subcoin);
            final RadioButton incoin = (RadioButton) dlg.findViewById(R.id.count_subin);
            final Button okButton = (Button) dlg.findViewById(R.id.count_subinput);
            final Button cancelButton = (Button) dlg.findViewById(R.id.count_subcancle);

            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(name.getText().toString().equals("")){
                        Toast.makeText(context, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                    else if(coin.getText().toString().equals("")){
                        Toast.makeText(context, "금액을 입력하세요.", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        customitem item = new customitem();
                        item.setResid(count++);
                        item.setItemname(name.getText().toString());
                        if(incoin.isChecked()){
                            item.setItemtype(tt[0]);
                        }
                        else{
                            item.setItemtype(tt[1]);
                        }
                        item.setItemcoin(Integer.parseInt(coin.getText().toString()));
                        adapter.addItem(item);
                        startService(new Intent(account.this, service_voice_congratulation.class));
                        Toast.makeText(context, "입력이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        dlg.dismiss();
                    }
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "취소되었습니다.", Toast.LENGTH_SHORT).show();
                    dlg.dismiss();
                }
            });
        }
    }
    class dbhelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "account_contacts.db";
        private static final int DATABASE_VERSION = 3;
        public dbhelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE contacts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, coin TEXT);");
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

}
