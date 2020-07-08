package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class answer extends AppCompatActivity {

    TextView tvtestbmi,tvtestclimb,tvtestsfmax,tvtestsitupmax,tvtestsljmax,tv12;
    float bmi,climb,sfmax,situpmax,sljmax;
    private String URL_REGIST="http://funar.net/api/postdata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        tv12=findViewById(R.id.textView12);
        tvtestbmi = (TextView)findViewById(R.id.tv_bmi);
        tvtestclimb = (TextView)findViewById(R.id.tv_climb);
        tvtestsfmax = (TextView)findViewById(R.id.tv_sfmax);
        tvtestsitupmax = (TextView)findViewById(R.id.tv_situpmax);
        tvtestsljmax = (TextView)findViewById(R.id.tv_sljmax);

        Intent intent = getIntent();
        String   name = intent.getStringExtra("name");
        bmi = intent.getFloatExtra("bmi",0);
        climb = intent.getFloatExtra("climb",0);
        sfmax = intent.getFloatExtra("sfmax",0);
        situpmax = intent.getFloatExtra("situpmax",0);
        sljmax = intent.getFloatExtra("sljmax",0);

        tv12.setText(name);
        tvtestbmi.setText((String.valueOf(bmi)));
        tvtestclimb.setText((String.valueOf(climb)));
        tvtestsfmax.setText((String.valueOf(sfmax)));
        tvtestsitupmax.setText((String.valueOf(situpmax)));
        tvtestsljmax.setText((String.valueOf(sljmax)));
    }
    public void save(View v){
        update();
    }

    private void update() {
        final String name =this.tv12.getText().toString().trim();
        final String bim = this.tvtestbmi.getText().toString().trim();
        final String climb = this.tvtestclimb.getText().toString().trim();
        final String sfmax = this.tvtestsfmax.getText().toString().trim();
        final String situpmax = this.tvtestsitupmax.getText().toString().trim();
        final String sljmax = this.tvtestsljmax.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1")){
                        Toast.makeText(answer.this,"紀錄成功!!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(answer.this,no2p2.class));
                        finish();
                    }else if (success.equals("0")) {
                        Toast.makeText(answer.this, "有東西沒輸入!!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(answer.this,"紀錄失敗!!"/*+e.toString()*/,Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(answer.this,"請明年再來 別亂輸!!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(answer.this,no2p2.class));
                Log.i("VolleyError", "[" + error + "]");
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("u_id",name);
                params.put("d_bmi",bim);
                params.put("d_climb",climb);
                params.put("d_sfmax",sfmax);
                params.put("d_sitemax",situpmax);
                params.put("d_sljmax",sljmax);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
