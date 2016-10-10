package com.startingandroid.registrationandlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tanmay on 21-09-2016.
 */

public class Display extends Activity {

    Button b1;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
    }
    public void sendMessage(View view) {
        final Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(Display.this,Customers.class);
                startActivity(launchActivity1);
            }
        });
    }

}
