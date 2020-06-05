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
        String msg = "<html><body><h1>Send SMS server</h1>\n";
        Map<String, String> parms = session.getParms();

        if (parms.get("number") == null) {
            msg += "<form action='?' method='get'>\n";
            msg += "<p>Your number: <input type='text' name='number'></p>\n";
            msg += "<p>Your sms body: <input type='text' name='smsbody'></p>\n";
            msg += "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("number") + "!</p>";
            System.out.println(parms.get("number"));
            System.out.println(parms.get("smsbody"));
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(parms.get("number"), null, parms.get("smsbody"), null, null);



        }
        return newFixedLengthResponse( msg + "</body></html>\n" );
    }



}
