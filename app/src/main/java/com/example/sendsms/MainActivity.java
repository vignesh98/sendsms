package com.example.sendsms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class MainActivity extends AppCompatActivity {

   // public static String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickButton1 = (Button) findViewById(R.id.startbutton);
        Button clickButton2 = (Button) findViewById(R.id.stopbutton);
        int port = 8080;
        final AndroidWebServer androidWebServer = new AndroidWebServer(port);


        clickButton1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    androidWebServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        clickButton2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               androidWebServer.stop();

            }
        });

    }


}