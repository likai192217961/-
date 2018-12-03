package com.example.likai20181203zk1;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.likai20181203zk1.sql.SqlDao;
import com.example.likai20181203zk1.view.MyfooterView;
import com.example.likai20181203zk1.view.MyheaderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = {"考拉三周年人气热销榜", "电动牙刷", "尤妮佳", "豆豆鞋", "沐浴露", "日东红茶", "榴莲", "雅诗兰黛"};
    private String[] data1 = {"基础护肤", "面部清洁", "面膜", "兰蔻", "雅诗兰黛", "资生堂", "眼部护理", "悦诗风吟", "美容护肤"};
    private ArrayList<String> zuijin1 = new ArrayList<>();
    private ArrayList<String> faxian1 = new ArrayList<>();
    private ArrayList<String> fenlei1 = new ArrayList<>();
    private MyheaderView head;
    private MyfooterView zuijin;
    private MyfooterView faxian;
    private MyfooterView fenlei;
    private TextView shanchu;
    private SqlDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        initView();
        dao = new SqlDao(MainActivity.this);
        if (!zuijin1.isEmpty()){
            zuijin.setData(zuijin1);
        }
    }

    private void initdata() {
        for (int i = 0; i < data.length; i++) {
            faxian1.add(data[i]);
        }
        for (int i = 0; i < data1.length; i++) {
            fenlei1.add(data1[i]);
        }
    }

    private void initView() {
        head = (MyheaderView) findViewById(R.id.head);
        head.getQuxiao().setOnClickListener(this);
        zuijin = (MyfooterView) findViewById(R.id.zuijin);
        faxian = (MyfooterView) findViewById(R.id.faxian);
        faxian.setData(faxian1);
        fenlei = (MyfooterView) findViewById(R.id.fenlei);
        fenlei.setData1(fenlei1);
        shanchu = (TextView) findViewById(R.id.shanchu);
        shanchu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quxiao:
                String s = head.getSousuo().trim();
                zuijin1.add(s);
                for (int j = 0; j <zuijin1.size() ; j++) {
                    ContentValues values=new ContentValues();
                    values.put("name",zuijin1.get(j));
                    dao.insert("text",null,values);
                }
                zuijin.removeChildView();
                zuijin.setData(zuijin1);
                break;
            case R.id.shanchu:
                for (int z = 0; z <zuijin1.size() ; z++) {
                    dao.delete("text","name=?",new String[]{zuijin1.get(z)});
                }
                zuijin1.clear();
                zuijin.removeChildView();
                break;
        }
    }
}
