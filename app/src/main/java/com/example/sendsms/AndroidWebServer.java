package com.example.sendsms;

import android.widget.Toast;

import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

public class AndroidWebServer extends NanoHTTPD {

    public String val = "null";

    MainActivity m = new MainActivity();

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
        val  = "Hello from web server";
        //m.val = "asdasds";
        //parms.get("username");
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n";
            msg += "<p>Your name: <input type='text' name='username'></p>\n";
            msg += "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }
        return newFixedLengthResponse( msg + "</body></html>\n" );
    }




}
