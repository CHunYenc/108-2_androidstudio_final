package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    EditText etid,ethappy;
    TextView tva,tv,tv2;
    RadioButton rdbmen,rdbwommen;
    RadioGroup rg_gender;
    private String URL_REGIST="http://funar.net/api/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tva=findViewById(R.id.tv_a);
        rdbmen=findViewById(R.id.rdb_men);
        rdbwommen=findViewById(R.id.rdb_wommen);
        etid =findViewById(R.id.et_id);
        ethappy=findViewById(R.id.et_happyday);
        rg_gender=findViewById(R.id.rg_gender);


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }
        });
    }

    private void selectRadioButton(){
        RadioButton rb = (RadioButton)register.this.findViewById(rg_gender.getCheckedRadioButtonId());
        //  tva.setText(rb.getText());
        if(rdbmen.isChecked()){
            tva.setText("1");
        }else if(rdbwommen.isChecked()){
            tva.setText("0");
        }
    }

    public void register(View v){
        Regist();
    }

    private void Regist() {
        final String name = this.etid.getText().toString().trim();
        final String password = this.ethappy.getText().toString().trim();
        final String gender = this.tva.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1")){
                        Toast.makeText(register.this,"註冊成功!!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(register.this,MainActivity.class));

                    }else if (success.equals("0")){
                        Toast.makeText(register.this,"帳號已註冊!!",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(register.this,"註冊失敗!!"/*+e.toString()*/,Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this,"註冊失敗2!!"+error.toString(),Toast.LENGTH_SHORT).show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("u_id",name);
                params.put("u_password",password);
                params.put("u_gender",gender);
                //   params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
