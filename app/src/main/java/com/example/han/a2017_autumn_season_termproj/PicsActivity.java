package com.example.han.a2017_autumn_season_termproj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by HAN on 2017-11-15.
 */

public class PicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pics);
        setTitle("나만보는갤러리");

        Button pics_back = (Button) findViewById(R.id.pics_back);

        pics_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }


    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }
        Integer[] postId = {R.drawable.po_1,R.drawable.po_2,R.drawable.po_3,R.drawable.po_4,R.drawable.po_5,R.drawable.po_6,R.drawable.po_7,R.drawable.po_8};

        public int getCount() {
            return postId.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){

            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(600,300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(postId[position]);

            final int pos = position;

            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(PicsActivity.this,R.layout.pics_dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(PicsActivity.this);
                    ImageView ivPost = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPost.setImageResource(postId[pos]);
                    dlg.setTitle("큰 사진");
                    dlg.setIcon(R.drawable.face);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return imageview;
        }

    }

}
