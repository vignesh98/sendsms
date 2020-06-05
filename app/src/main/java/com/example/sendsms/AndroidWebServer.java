package com.example.sendsms;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.Map;
import java.util.logging.Handler;

import fi.iki.elonen.NanoHTTPD;


public class AndroidWebServer extends NanoHTTPD {

    public AndroidWebServer(int port) {

        super(port);
    }

    public AndroidWebServer(String hostname, int port) {
        super(hostname, port);
    }


    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n";
            msg += "<p>Your name: <input type='text' name='username'></p>\n";
            msg += "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
            System.out.println("Sending SMS ....");
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("6362485197", null, "sms message", null, null);



        }
        return newFixedLengthResponse( msg + "</body></html>\n" );
    }



}
