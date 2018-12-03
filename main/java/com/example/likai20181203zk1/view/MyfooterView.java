package com.example.likai20181203zk1.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.likai20181203zk1.R;

import java.util.ArrayList;

public class MyfooterView extends LinearLayout {

    private final int kuan;

    public MyfooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        kuan = metrics.widthPixels;
        setOrientation(VERTICAL);
    }
    public LinearLayout getLin(){
        LinearLayout linearLayout=new LinearLayout(getContext());
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        this.addView(linearLayout);
        return linearLayout;
    }
    public void setData(ArrayList<String> data){
        LinearLayout lin = getLin();
        for (int i = 0; i < data.size(); i++) {
            final String shuju = data.get(i);
            int numWidth=0;
            int childCount = lin.getChildCount();
            for (int j = 0; j <childCount ; j++) {
                TextView tv = (TextView) lin.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int left=layoutParams.leftMargin;
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numWidth+=tv.getMeasuredWidth()+tv.getPaddingLeft()+tv.getPaddingRight()+left;
            }
            TextView datatext=getText();
            datatext.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "您点击的数据是"+shuju, Toast.LENGTH_SHORT).show();
                }
            });
            LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.leftMargin=10;
            params.bottomMargin=20;
            datatext.setText(shuju);
            datatext.setLayoutParams(params);
            datatext.measure(getMeasuredWidth(),getMeasuredHeight());
            int textkuan = datatext.getMeasuredWidth() + datatext.getPaddingLeft() + datatext.getPaddingRight();
            if (kuan>=numWidth+textkuan){
                lin.addView(datatext);
            }else{
                lin=getLin();
                lin.addView(datatext);
            }
        }
    }
    public TextView getText(){
        TextView textView=new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.style);
        textView.setPadding(10,10,10,10);
        return  textView;
    }
    public void removeChildView(){
        removeAllViews();
    }
    public void setData1(ArrayList<String> data1){
        LinearLayout lin = getLin();
        for (int i = 0; i < data1.size(); i++) {
            final String shuju = data1.get(i);
            int numWidth=0;
            int childCount = lin.getChildCount();
            for (int j = 0; j <childCount ; j++) {
                TextView tv = (TextView) lin.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int left=layoutParams.leftMargin;
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numWidth+=tv.getMeasuredWidth()+tv.getPaddingLeft()+tv.getPaddingRight()+left;
            }
            TextView datatext=getText1();
            datatext.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "您点击的数据是"+shuju, Toast.LENGTH_SHORT).show();
                }
            });
            LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.leftMargin=10;
            params.bottomMargin=20;
            datatext.setText(shuju);
            datatext.setLayoutParams(params);
            datatext.measure(getMeasuredWidth(),getMeasuredHeight());
            int textkuan = datatext.getMeasuredWidth() + datatext.getPaddingRight() + datatext.getPaddingRight();
            if (kuan>=numWidth+textkuan){
                lin.addView(datatext);
            }else{
                lin=getLin();
                lin.addView(datatext);
            }
        }
    }
    public TextView getText1(){
        TextView textView=new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.style1);
        textView.setPadding(10,10,10,10);
        return  textView;
    }
}
