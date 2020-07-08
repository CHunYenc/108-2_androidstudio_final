package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class no2p3 extends AppCompatActivity {

    TextView tvtestbmi,tvtestclimb,tvtestsfmax,tvtestsitupmax,tvtestsljmax;
    int sex = 0;
    int pass = 0;
    ImageView impass,imagain;


    float bmi,climb,sfmax,situpmax,sljmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no2p3);

        tvtestbmi = (TextView)findViewById(R.id.tv_testbmi);
        tvtestclimb = (TextView)findViewById(R.id.tv_testclimb);
        tvtestsfmax = (TextView)findViewById(R.id.tv_testsfmax);
        tvtestsitupmax = (TextView)findViewById(R.id.tv_testsitupmax);
        tvtestsljmax = (TextView)findViewById(R.id.tv_testsljmax);
        impass = (ImageView)findViewById(R.id.im_pass);
        imagain=(ImageView)findViewById(R.id.im_again);

        Intent intent = getIntent();
        bmi = intent.getFloatExtra("bmi",0);
        climb = intent.getFloatExtra("climb",0);
        sfmax = intent.getFloatExtra("sfmax",0);
        situpmax = intent.getFloatExtra("situpmax",0);
        sljmax = intent.getFloatExtra("sljmax",0);
        //sex = intent.getIntExtra("sex",0);

        //tvtest.setText("" + bmi +"\n" + climb +"\n"+ sfmax +"\n"+ situpmax +"\n"+ sljmax );

        if(sex == 1){
            if(18<=bmi&&bmi<=25){
                pass++;
                tvtestbmi.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestbmi.setText("BMIpass" );
            }
            else{
                tvtestbmi.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestbmi.setText("BMIfail" );
            }
            if(climb>=51){
                pass++;
                tvtestclimb.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestclimb.setText("登階pass" );
            }
            else{
                tvtestclimb.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestclimb.setText("登階fail" );
            }

            if (sfmax>=26){
                pass++;
                tvtestsfmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsfmax.setText("坐姿體前彎pass" );
            }
            else{
                tvtestsfmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsfmax.setText("坐姿體前彎fail" );
            }
            if(situpmax>=34){
                pass++;
                tvtestsitupmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsitupmax.setText("仰臥起坐pass" );
            }
            else {
                tvtestsitupmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsitupmax.setText("仰臥起坐fail");
            }
            if(sljmax>=210){
                pass++;
                tvtestsljmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsljmax.setText("立定跳遠pass" );
            }
            else {
                tvtestsljmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsljmax.setText("立定跳遠fail");
            }
        }
        else {
            if(18<=bmi&&bmi<=23){
                pass++;
                tvtestbmi.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestbmi.setText("BMIpass" );
            }
            else{
                tvtestbmi.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestbmi.setText("BMIfail" );
            }
            if(climb>=51){
                pass++;
                tvtestclimb.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestclimb.setText("登階pass" );
            }
            else{
                tvtestclimb.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestclimb.setText("登階fail" );
            }

            if (sfmax>=29){
                pass++;
                tvtestsfmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsfmax.setText("坐姿體前彎pass" );
            }
            else{
                tvtestsfmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsfmax.setText("坐姿體前彎fail" );
            }
            if(situpmax>=24){
                pass++;
                tvtestsitupmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsitupmax.setText("仰臥起坐pass" );
            }
            else {
                tvtestsitupmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsitupmax.setText("仰臥起坐fail");
            }
            if(sljmax>=145){
                pass++;
                tvtestsljmax.setTextColor(Color.parseColor("#FF00FF00"));//設定顏色
                tvtestsljmax.setText("立定跳遠pass" );
            }
            else {
                tvtestsljmax.setTextColor(Color.parseColor("#FFFF0000"));//設定顏色
                tvtestsljmax.setText("立定跳遠fail");
            }
        }

        if(pass>=3) {
            impass.setVisibility(View.VISIBLE);
            imagain.setVisibility(View.GONE);
        }
        else {
            imagain.setVisibility(View.VISIBLE);
            impass.setVisibility(View.GONE);
        }


    }
    public void ans(View v){
        Intent it = getIntent();
        String name =  it.getStringExtra("name");

        Intent intent = new Intent(this , answer.class);
        intent.putExtra("name", name);
        intent .putExtra("bmi",bmi);
        intent .putExtra("climb",climb);
        intent .putExtra("sfmax",sfmax);
        intent .putExtra("situpmax",situpmax);
        intent .putExtra("sljmax",sljmax);
        startActivity(intent);
        finish();
    }


}