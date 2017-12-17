package com.example.han.a2017_autumn_season_termproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2017년 겨울 텀프로젝트");

        startActivity(new Intent(this, LoadingActivity.class));

        Button btnTimetable = (Button) findViewById(R.id.btnTimetable);
        Button btnBoard = (Button) findViewById(R.id.btnBoard);
        Button btnPhone = (Button) findViewById(R.id.btnPhone);
        Button btnPics = (Button) findViewById(R.id.btnPics);
        Button btnSetup = (Button) findViewById(R.id.btnSetup);

        TextView main_name = (TextView) findViewById(R.id.main_name);
        ImageView main_photo = (ImageView) findViewById(R.id.main_photo);

        //설정에서 만들어논 인텐트를 받아오기 위한 getIntent, 변수를 만들어서 가져온 string값을 넣어준다.
        Intent intent = getIntent();
        String setup_name = intent.getStringExtra("setup_name");
        final Integer change_img = intent.getIntExtra("change_img", 0);

        if (setup_name == null){
            main_name.setText("창훈");
        }else{
            main_name.setText(setup_name);
        }

        if(change_img != 0){
            main_photo.setImageResource(change_img);
        }

        //각 버튼의 onClick Method 정의.. 지금은 인텐트를 통해 이동하는것만 있음

        btnTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimetableActivity.class);
                startActivity(intent);
            }
        });

        btnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhonebookActivity.class);
                startActivity(intent);
            }
        });

        btnPics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PicsActivity.class);
                startActivity(intent);
            }
        });

        btnSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
                startActivity(intent);
            }
        });
    }
}
