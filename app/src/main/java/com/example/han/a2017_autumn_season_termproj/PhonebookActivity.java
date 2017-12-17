package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by HAN on 2017-11-15.
 */

public class PhonebookActivity extends  Activity{

    myDBHelper dbHelpe;
    SQLiteDatabase sqlDB;

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"phoneDB",null,1);
            Toast.makeText(PhonebookActivity.this,"폰북 DB생성",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //게시판 db 생성
            db.execSQL("CREATE TABLE phoneTable(_ID INTEGER PRIMARY KEY AUTOINCREMENT,PNU INTEGER,NAME TEXT);");
            Toast.makeText(PhonebookActivity.this,"폰북TABLE생성",Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS phoneTable");
            onCreate(db);
            Toast.makeText(PhonebookActivity.this,"폰북버전업",Toast.LENGTH_SHORT).show();
        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.phone_book);

            Button p_back = (Button) findViewById(R.id.phone_back);
            Button p_insert = (Button) findViewById(R.id.phone_insert);
            final Button p_hidden = (Button) findViewById(R.id.phone_hidden);

            final EditText p_name = (EditText) findViewById(R.id.phone_name);
            final EditText p_number = (EditText) findViewById(R.id.phone_number);
            final EditText ps_name = (EditText) findViewById(R.id.phonesearch_name);

            final TextView v_id =(TextView) findViewById(R.id.view_id);
            final TextView v_name =(TextView) findViewById(R.id.view_name);
            final TextView v_num =(TextView) findViewById(R.id.view_numb);
            TextView p_delete = (TextView) findViewById(R.id.phone_delete);
            TextView p_search = (TextView) findViewById(R.id.phone_search);

            dbHelpe = new myDBHelper(this);

            p_search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sqlDB=dbHelpe.getReadableDatabase();
                    Cursor cursor;
                    String query ="SELECT * FROM phoneTable where NAME ='"+ps_name.getText().toString()+"';";
                    cursor = sqlDB.rawQuery(query,null);

                    System.out.println(query);

                    String strId = "순번"+"\r\n"+"------"+"\r\n";
                    String strName = "이름"+"\r\n"+"------"+"\r\n";
                    String strPhone = "번호"+"\r\n"+"------"+"\r\n";

                    while (cursor.moveToNext()){
                        strId += cursor.getInt(0)+"\r\n";
                        strPhone += cursor.getString(1)+"\r\n";
                        strName += cursor.getString(2)+"\r\n";
                    }

                    v_id.setText(strId);
                    v_name.setText(strName);
                    v_num.setText(strPhone);

                    cursor.close();
                    sqlDB.close();

                }
            });

            p_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //삭제를 할겁니다
                    sqlDB = dbHelpe.getWritableDatabase();
                    //삭제할 이름
                    String searchName = ps_name.getText().toString();
                    String query = "DELETE FROM phoneTable WHERE NAME = '"+searchName+"';" ;
                    System.out.println(searchName);
                    sqlDB.execSQL(query);
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"삭제 완료!",Toast.LENGTH_SHORT).show();

                    p_hidden.callOnClick();
                }
            });

            p_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            p_insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //DB에 EditText 내용을 받아서 DB에 삽입, 동시에 Cursor를 사용해서 select쿼리 실행
                    sqlDB = dbHelpe.getWritableDatabase();
                    String Name = p_name.getText().toString();
                    String Number = p_number.getText().toString();

                    String query = "INSERT INTO phoneTable (pnu,name) values('"+Number+"','"+Name+"');" ;
                    sqlDB.execSQL(query);
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"등록 완료!",Toast.LENGTH_SHORT).show();

                    p_hidden.callOnClick();
                }
            });

            p_hidden.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sqlDB=dbHelpe.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB.rawQuery("SELECT * FROM phoneTable;",null);

                    String strId = "순번"+"\r\n"+"------"+"\r\n";
                    String strName = "이름"+"\r\n"+"------"+"\r\n";
                    String strPhone = "번호"+"\r\n"+"------"+"\r\n";

                    while (cursor.moveToNext()){
                        strId += cursor.getInt(0)+"\r\n";
                        strPhone += cursor.getString(1)+"\r\n";
                        strName += cursor.getString(2)+"\r\n";
                    }

                    v_id.setText(strId);
                    v_name.setText(strName);
                    v_num.setText(strPhone);

                    cursor.close();
                    sqlDB.close();
                }
            });

            p_hidden.callOnClick();
        }
}
