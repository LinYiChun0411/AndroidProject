package com.example.root.m10309108hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int index=0;
    private ImageView imgShow;
    private ImageView imgLeft;
    private ImageView imgRight;
    private TextView txPages;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         imgShow =(ImageView)findViewById(R.id.imgShow);
         imgLeft= (ImageView)findViewById(R.id.imgLeft);
         imgRight= (ImageView)findViewById(R.id.imgRight);
         txPages=(TextView)findViewById(R.id.txPages);

        list.add(R.drawable.img01);
        list.add(R.drawable.img02);
        list.add(R.drawable.img03);
        list.add(R.drawable.img04);
        list.add(R.drawable.img05);
        txPages.setText(index+1+"/"+list.size());

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 0) {
                    index--;
                    imgShow.setImageResource(list.get(index));
                    txPages.setText(index+1+"/"+list.size());
                }
            }
        });

        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < list.size()-1) {
                    index++;
                    imgShow.setImageResource(list.get(index));
                    txPages.setText(index+1+"/"+list.size());
                }
            }
        });



    }
}
