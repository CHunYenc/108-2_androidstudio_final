package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class no2p2 extends AppCompatActivity {

    Button btfinal;
//    String showUri = "http://120.105.132.39/app_link/loadingdata.php";
//    com.android.volley.RequestQueue requestQueue;
    EditText etbmiheight,etbmiweight,etclimbfirst,etclimbsecond,etclimbthird,etsffirst,etsfsecond,etsitup30,etsitup60,etsljfirst,etsljsecond;
    float bmi,climb,sfmax,situpmax,sljmax;
    //int sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no2p2);

      //  requestQueue = Volley.newRequestQueue(getApplicationContext());

        btfinal = (Button)findViewById(R.id.bt_final);
        etbmiheight = (EditText)findViewById(R.id.et_bmiheight);
        etbmiweight = (EditText)findViewById(R.id.et_bmiweight);
        etclimbfirst = (EditText)findViewById(R.id.et_climbfirst);
        etclimbsecond = (EditText)findViewById(R.id.et_climbsecond);
        etclimbthird = (EditText)findViewById(R.id.et_climbthird);
        etsffirst = (EditText)findViewById(R.id.et_sffirst);
        etsfsecond = (EditText)findViewById(R.id.et_sfsecond);
        etsitup30 = (EditText)findViewById(R.id.et_situp30);
        etsitup60 = (EditText)findViewById(R.id.et_situp60);
        etsljfirst = (EditText)findViewById(R.id.et_sljfirst);
        etsljsecond = (EditText)findViewById(R.id.et_sljsecond);

    }

    public void count(View v){
        float weight = Float.parseFloat(etbmiweight.getText().toString());
        float height = Float.parseFloat(etbmiheight.getText().toString());
        float climbtotal = Integer.parseInt(etclimbfirst.getText().toString()) + Integer.parseInt(etclimbsecond.getText().toString()) + Integer.parseInt(etclimbthird.getText().toString()) ;
        float sf1 = Integer.parseInt(etsffirst.getText().toString());
        float sf2 = Integer.parseInt(etsfsecond.getText().toString());
        float slj1 = Integer.parseInt(etsljfirst.getText().toString());
        float slj2 = Integer.parseInt(etsljsecond.getText().toString());

        bmi = weight/((height / 100) * (height / 100));
        climb = 180 * 100 / climbtotal;
        if (sf1 < sf2) sfmax = sf2; else sfmax = sf1;
        situpmax = Integer.parseInt(etsitup60.getText().toString());
        if (slj1 < slj2) sljmax = slj2; else sljmax = slj1;

        Intent it = getIntent();
      String name =  it.getStringExtra("name");

        Intent intent = new Intent(this, no2p3.class);
        intent.putExtra("name", name);
        intent .putExtra("bmi",bmi);
        intent .putExtra("climb",climb);
        intent .putExtra("sfmax",sfmax);
        intent .putExtra("situpmax",situpmax);
        intent .putExtra("sljmax",sljmax);
        startActivity(intent);
    }

    public void yy(View v){
        Intent it = getIntent();
        String name =  it.getStringExtra("name");
        Intent intent = new Intent(no2p2.this,getdata.class);
        intent.putExtra("name", name);
        startActivity(intent);
        finish();
    }

}
