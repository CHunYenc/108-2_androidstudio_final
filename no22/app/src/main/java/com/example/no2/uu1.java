package com.example.no2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uu1 extends AppCompatActivity {
    String showUri = "http://localhost/api/getdata";
//    com.android.volley.RequestQueue requestQueue;
//    @RequiresApi(api = Build.VERSION_CODES.N)
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_getdata);
//
//        final  TextView txt;
//        txt =(TextView) findViewById(R.id.txt);
//
//        RequestQueue mQueue = Volley.newRequestQueue(this);
////        requestQueue = Volley.newRequestQueue(getApplicationContext());
////
////        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
////                (Request.Method.GET,showUri, new Response.Listener<JSONObject>() {
////
////                    @Override
////
////                    public void onResponse(JSONObject response) {
////
////                        System.out.println(response.toString());
////
////                        try {
////
////                            JSONArray data = response.getJSONArray("data");
////
////                            //這邊要和上面json的名稱一樣
////
////                            //下邊是把全部資料都印出來
////
////                            for (int i = 0; i < data.length(); i++) {
////
////                                JSONObject jasondata = data.getJSONObject(i);
////
////                                String id = jasondata.getString("u_id");
////
////                                String bmi = jasondata.getString("d_bmi");
////                                String climb = jasondata.getString("d_climb");
////                                String sfmax = jasondata.getString("d_sfmax");
////                                String sitemax = jasondata.getString("d_sitemax");
////                                String sljmax = jasondata.getString("d_sljmax");
////                                String time = jasondata.getString("d_ctime");
////
////                                txt.append("學號:"+ id + "\n " +"bmi = " + bmi + "\n" + "登階 =" + climb + "\n"+"肢體前彎 =" + sfmax + "\n"+"仰臥起坐 =" + sitemax + "\n"+"立定跳遠 =" + sljmax + "\n"+"上傳時間 =" + time + "\n");
////
//////txt是textview
////
////                            }
////
////                            txt.append("===\n");//把資料放到textview顯示出來
////
////                        } catch (JSONException e) {
////
////                            e.printStackTrace();
////                            Toast.makeText(getdata.this,"抓取失敗!!"/*+e.toString()*/,Toast.LENGTH_SHORT).show();
////
////                        }
////
////                    }
////
////                }, new Response.ErrorListener() {
////
////                    @Override
////
////                    public void onErrorResponse(VolleyError error) {
////
////                        Toast.makeText(getdata.this,"抓取失敗2!!"+error.toString(),Toast.LENGTH_SHORT).show();
////                        Log.i("VolleyError", "[" + error + "]");
////
////                    }
////
////                });
////
////        requestQueue.add(jsonObjectRequest);
//
//        StringRequest getRequest = new StringRequest(showUri,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//                        try {
//
//                            JSONArray  array = new JSONArray(s);
//                            for (int i = 0; i < array.length(); i++) {
//                                JSONObject jasondata = array.getJSONObject(i);
//                                String id = jasondata.getString("u_id");
//                                String bmi = jasondata.getString("d_bmi");
//                                String climb = jasondata.getString("d_climb");
//                                String sfmax = jasondata.getString("d_sfmax");
//                                String sitemax = jasondata.getString("d_sitemax");
//                                String sljmax = jasondata.getString("d_sljmax");
//                                String time = jasondata.getString("d_ctime");
//
//                                txt.append("學號:" + id + "\n " + "bmi = " + bmi + "\n" + "登階 =" + climb + "\n" + "肢體前彎 =" + sfmax + "\n" + "仰臥起坐 =" + sitemax + "\n" + "立定跳遠 =" + sljmax + "\n" + "上傳時間 =" + time + "\n");
//                            }
//                            txt.append("===\n");//把資料放到textview顯示出來
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//
//                    }
//                });
//        mQueue.add(getRequest);
//   }

}
