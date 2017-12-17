package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HAN on 2017-11-15.
 */

public class BoardActivity extends Activity{

    myDBHelper dbHelpe;
    SQLiteDatabase sqlDB;

    //DB를 생성합니다
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"intDB",null,1);
            Toast.makeText(BoardActivity.this,"DB생성",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //게시판 db 생성
            db.execSQL("CREATE TABLE boardTable(_ID INTEGER PRIMARY KEY AUTOINCREMENT, CONTENT TEXT);");
            Toast.makeText(BoardActivity.this,"TABLE생성",Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS boardTable");
            onCreate(db);
            Toast.makeText(BoardActivity.this,"버전업",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        setTitle("나혼자쓰는게시판");


        Button btn_write = (Button) findViewById(R.id.btn_write);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        Button btn_list = (Button) findViewById(R.id.btn_list);
        final TextView edtNum = (TextView) findViewById(R.id.edtNum);
        final TextView edtContent = (TextView) findViewById(R.id.edtContent);

        dbHelpe = new myDBHelper(this);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //select 하기위해 db를 readable한다
                sqlDB=dbHelpe.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM boardTable;",null);

                String strNum = "숫자"+"\r\n"+"------"+"\r\n";
                String strCont = "내용"+"\r\n"+"------"+"\r\n";

                while (cursor.moveToNext()){
                    strNum += cursor.getString(0)+"\r\n";
                    strCont += cursor.getString(1)+"\r\n";
                }

                edtNum.setText(strNum);
                edtContent.setText(strCont);

                cursor.close();
                sqlDB.close();
            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardWriteActivity.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_list.callOnClick();
    }
}
