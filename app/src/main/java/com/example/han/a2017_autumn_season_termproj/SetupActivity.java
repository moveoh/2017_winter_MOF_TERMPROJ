package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.han.a2017_autumn_season_termproj.R.id.main_name;
import static com.example.han.a2017_autumn_season_termproj.R.id.setup_backbtn;
import static com.example.han.a2017_autumn_season_termproj.R.id.setup_name;

/**
 * Created by HAN on 2017-11-15.
 */

public class SetupActivity extends Activity{

    Integer[] imgID = {R.drawable.po_1,R.drawable.po_2,R.drawable.po_3,R.drawable.po_4,R.drawable.po_5,R.drawable.po_6,R.drawable.po_7,R.drawable.po_8};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);
        setTitle("나혼자설정하기");

        //뒤로가기버튼
        Button setup_backbtn = (Button) findViewById(R.id.setup_backbtn);
        //이름 바꾸기 버튼
        Button rename_confirm = (Button) findViewById(R.id.rename_confirm);

        final GridView gv = (GridView)findViewById(R.id.gridView2);
        MyGridAdapter2 gAdapter = new MyGridAdapter2(this);
        gv.setAdapter(gAdapter);



        //이름바꾸기 버튼을 누르면 setup_name에서 새로 작성한 이름의 text를 받아와서 main_name의(메인화면의이름) Text를 바꿔준다
        rename_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //새로 설정할 이름의 EditText
                final EditText setup_name = (EditText) findViewById(R.id.setup_name);

                //intent로 값 넘기기 (putExtra, 사용할 곳에서 받을떄 setup_name으로 받아오면된다
                Intent intent = new Intent(SetupActivity.this, MainActivity.class);
                intent.putExtra("setup_name",setup_name.getText().toString());
                startActivity(intent);
                Toast.makeText(SetupActivity.this, "이름을 설정했습니다",Toast.LENGTH_SHORT).show();
            }
        });

        setup_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public class MyGridAdapter2 extends BaseAdapter {
        Context context;
        public MyGridAdapter2(Context c){
            context = c;
        }

        public int getCount() {
            return imgID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(10, 10, 10, 10);

            imageView.setImageResource(imgID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SetupActivity.this, MainActivity.class);
                    intent.putExtra("change_img", imgID[pos]);
                    startActivity(intent);
                    Toast.makeText(SetupActivity.this, "프로필 이미지를 변경하였습니다.", Toast.LENGTH_SHORT).show();
                }
            });

            return imageView;
        }

    }
}
