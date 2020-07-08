package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    EditText etid, ethappy;

    private String url_address = "http://funar.net/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etid = findViewById(R.id.et_id);
        ethappy = findViewById(R.id.et_happyday);

    }

    public void gogo(View V) {

        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }

    public void login(View v) {
        String mid = etid.getText().toString().trim();
        String mhappy = ethappy.getText().toString().trim();
        Login(mid, mhappy);

    }

    private void Login(final String name, final String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_address, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1")) {
                        Intent intent = (new Intent(MainActivity.this, no2p2.class));
                        intent.putExtra("name", name);
                        startActivity(intent);
                    } else if (success.equals("0")) {
                        Toast.makeText(MainActivity.this, "帳號OR密碼錯誤!!!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "登入失敗，請重新輸入", Toast.LENGTH_SHORT).show();
                    Log.i("JSONException", "[" + e + "]");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("VolleyError", "[" + error + "]");
                Toast.makeText(MainActivity.this, "登入失敗，請重新輸入" , Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("u_id", name);
                params.put("u_password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
