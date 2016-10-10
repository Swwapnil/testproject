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
                Intent launchActivity1 = new Intent(Display.this, Customers.class);
                startActivity(launchActivity1);


            }
        });
    }

    public void sendM(View view) {
        final Button button = (Button) findViewById(R.id.butto3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity2 = new Intent(Display.this, Before.class);
                startActivity(launchActivity2);

            }

        });

    }
    public void send(View view) {
        final Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity2 = new Intent(Display.this, ConSearch.class);
                startActivity(launchActivity2);

            }

        });

    }

    public void upl(View view) {
        final Button button = (Button) findViewById(R.id.Upload1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity2 = new Intent(Display.this, Upload.class);
                startActivity(launchActivity2);

            }

        });



    }
}
