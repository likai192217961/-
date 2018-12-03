package com.example.likai20181203zk1.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.likai20181203zk1.R;

public class MyheaderView extends LinearLayout {

    private final EditText sousuo;
    private final TextView quxiao;

    public MyheaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LinearLayout.inflate(context, R.layout.head,this);
        sousuo = findViewById(R.id.suosou);
        quxiao = findViewById(R.id.quxiao);
    }
    public String getSousuo(){
        String s = sousuo.getText().toString();
        return s;
    }
    public TextView  getQuxiao(){
        return quxiao;
    }
}
