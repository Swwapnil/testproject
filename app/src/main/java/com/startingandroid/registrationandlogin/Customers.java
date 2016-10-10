package com.startingandroid.registrationandlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Customers extends AppCompatActivity {
    //Button btnMove;
    private EditText fullName, age_a,gender_g,mobile_m,birth_b,Email_e,Add_a;
    private Button btnMove;
    private Session session;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_customers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        session = new Session(Customers.this);

        if (session.getLoggedIn()) {


            btnMove = (Button) findViewById(R.id.btnMove);
            fullName = (EditText) findViewById(R.id.fullname);
            age_a = (EditText) findViewById(R.id.age_a);
            gender_g = (EditText) findViewById(R.id.gender_g);
            mobile_m = (EditText) findViewById(R.id.mobile_m);
            birth_b = (EditText) findViewById(R.id.birth_b);
            Email_e = (EditText) findViewById(R.id.Email_e);
            Add_a = (EditText) findViewById(R.id.Add_a);


            btnMove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = fullName.getText().toString();
                    String age = age_a.getText().toString();
                    String gender = gender_g.getText().toString();
                    String mobile = mobile_m.getText().toString();
                    String birth = birth_b.getText().toString();
                    String email = Email_e.getText().toString();
                    String Add = Add_a.getText().toString();

                    if (!name.isEmpty() && !email.isEmpty() && !Add.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !mobile.isEmpty() && !birth.isEmpty()) {
                        registerUser(name, age, gender, mobile, birth, email, Add);

                    } else {
                        Snackbar.make(v, "Please enter the credentials!", Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
            });


        }

    }
//customers--------------------------------------------------------------------------------------------------




    private void registerUser(final String name, final String age,
                              final String gender,final String mobile,final String birth,final String email,final String Add) {
        // Tag used to cancel the request
        String tag_string_req = "req_profile";

        pDialog.setMessage("Saving Data ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppURLs.URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {

                        Intent intent = new Intent(
                                Customers.this,
                                Bodycompositionparameters.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "profile");
                params.put("name", name);
                params.put("age", age);
                params.put("gender", gender);
                params.put("mobile", mobile);
                params.put("birth", birth);
                params.put("email", email);
                params.put("Address", Add);

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
