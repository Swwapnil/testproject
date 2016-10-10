package com.startingandroid.registrationandlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Customers extends AppCompatActivity {
    Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_customers);




    }
    public void sendMess(View view) {
        final Button button = (Button) findViewById(R.id.btnMove);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(Customers.this,Bodycompositionparameters.class);
                startActivity(launchActivity1);
            }
        });
    }


}
