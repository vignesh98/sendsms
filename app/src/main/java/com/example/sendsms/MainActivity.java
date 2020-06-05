package com.example.sendsms;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickButton1 = (Button) findViewById(R.id.startbutton);
        Button clickButton2 = (Button) findViewById(R.id.stopbutton);
        final TextView tv1 = (TextView)findViewById(R.id.status);
        tv1.setText("Server Not Started");
        int port = 8080;
        final AndroidWebServer androidWebServer = new AndroidWebServer(port);


        clickButton1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    androidWebServer.start();
                    tv1.setText("Server Started and is Running");
                    tv1.setTextColor(Color.parseColor("#008000"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        clickButton2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               androidWebServer.stop();
                tv1.setText("Server stopped");
                tv1.setTextColor(Color.parseColor("#FF0000"));

            }
        });

    }


}