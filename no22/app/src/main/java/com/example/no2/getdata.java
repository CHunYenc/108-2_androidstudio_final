package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class getdata extends AppCompatActivity {
    private RequestQueue mQueue;
    TextView tv1, tv2;
    EditText etid, ethappy;
    TextView txt, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);
        txt = findViewById(R.id.txt);
       // Button buttonParse = findViewById(R.id.button3);
        mQueue = Volley.newRequestQueue(this);
        Intent it = getIntent();
        String name =  it.getStringExtra("name");

        String url = "http://funar.net/api/getdata/"+name;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);
                                String d_bmi = employee.getString("d_bmi");
                                String d_climb = employee.getString("d_climb");
                                String d_id = employee.getString("d_id");
                                String d_sfmax = employee.getString("d_sfmax");
                                String d_sitemax = employee.getString("d_sitemax");
                                String d_sljmax = employee.getString("d_sljmax");
                                String d_ctime = employee.getString("d_ctime");

                                txt.append("測驗編號: " + d_id + "\n " + "bmi =  " + d_bmi + "\n" + "登階 = " + d_climb + "\n" + "肢體前彎 = " + d_sfmax + "\n" + "仰臥起坐 = " + d_sitemax + "\n" + "立定跳遠 = " + d_sljmax + "\n" + "上傳時間 = " + d_ctime + "\n");
                            }
                            txt.append("===\n");//把資料放到textview顯示出來
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
//        buttonParse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jsonParse();
//            }
//        });
//    }
//
//    private void jsonParse() {
//
//    }
    }
}
