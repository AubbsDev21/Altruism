package com.example.aubre.altruism;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Aubre on 7/12/2016.
 */
public class AltruismApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("tjCuXTY0YxTCWF6BucSIPvRAeoTyRp1MyJbdsoHs")
                .clientKey("g5HPsvJ6ik70RyzbT3rCUgYcKlsT22dd72RURdEz")
                .server("https://parseapi.back4app.com")



        .build()
        );
    }
}
