package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HAN on 2017-11-15.
 */


public class BoardWriteActivity extends Activity {

    myDBHelper myHelper;
    EditText boar_board;
    SQLiteDatabase sqlDB;

    //DB를 생성합니다
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"intDB",null,1);
            Toast.makeText(BoardWriteActivity.this,"DB생성",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //게시판 db 생성
            db.execSQL("CREATE TABLE boardTable(_ID INTEGER PRIMARY KEY AUTOINCREMENT, CONTENT TEXT);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS boardTable");
            onCreate(db);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);
        setTitle("게시글 작성!");

        Button btnWrite = (Button) findViewById(R.id.board_write);
        Button btnBack = (Button) findViewById(R.id.board_back);
        boar_board = (EditText) findViewById(R.id.boar_board);

        myHelper = new myDBHelper(this);

//        글쓰기 페이지에서 뒤로가기 버튼 동작
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        글쓰기 페이지에서 글 쓰기 누름 -> SQLite를 통해서 DB에 Insert 쿼리 동작
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DB에 EditText 내용을 받아서 DB에 삽입
                sqlDB = myHelper.getWritableDatabase();
                String content = boar_board.getText().toString();
                String query = "INSERT INTO boardTable (content) values('"+content+"');" ;
                //Query문.. 틀렸나 헷갈림 나중에 오류나면 여기 먼저 확인
                sqlDB.execSQL(query);
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"등록 완료!",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BoardWriteActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
