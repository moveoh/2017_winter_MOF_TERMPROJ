package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by HAN on 2017-11-15.
 */

public class TimetableActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        setTitle("나만의시간표");

        Button btn_back = (Button) findViewById(R.id.timetable_back);
        TextView mof1 = (TextView) findViewById(R.id.mof1);
        TextView mof2 = (TextView) findViewById(R.id.mof2);
        TextView emba1 = (TextView) findViewById(R.id.emba1);
        TextView emba2 = (TextView) findViewById(R.id.emba2);
        TextView vision1 = (TextView) findViewById(R.id.vision1);
        TextView vision2 = (TextView) findViewById(R.id.vision2);
        TextView indb1 = (TextView) findViewById(R.id.indb1);
        TextView indb2 = (TextView) findViewById(R.id.indb2);
        TextView soen = (TextView) findViewById(R.id.soen1);

        mof1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this, "모바일프로그래밍\n" + "김영봉교수님\n" + "A12-322",Toast.LENGTH_SHORT).show();
            }
        });
        mof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this, "모바일프로그래밍\n" + "김영봉교수님\n" + "A12-322",Toast.LENGTH_SHORT).show();
            }
        });

        vision1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"영상비전처리\n" + "신봉기교수님\n" + "A12-325",Toast.LENGTH_SHORT).show();
            }
        });
        vision2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"영상비전처리\n" + "신봉기교수님\n" + "A12-325",Toast.LENGTH_SHORT).show();
            }
        });

        emba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"임베디드시스템 프로그래밍\n" + "권오흠교수님\n" + "A13-226",Toast.LENGTH_SHORT).show();
            }
        });
        emba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"임베디드시스템 프로그래밍\n" + "권오흠교수님\n" + "A13-226",Toast.LENGTH_SHORT).show();
            }
        });

        indb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"데이터베이스 및 실습\n" + "송하주교수님\n" + "A12-320",Toast.LENGTH_SHORT).show();
            }
        });
        indb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"데이터베이스 및 실습\n" + "송하주교수님\n" + "A12-320",Toast.LENGTH_SHORT).show();
            }
        });
        soen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TimetableActivity.this,"소프트웨어공학\n" + "박만곤교수님\n" + "A12-322",Toast.LENGTH_SHORT).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
