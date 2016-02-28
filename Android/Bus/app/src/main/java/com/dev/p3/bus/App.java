package com.dev.p3.bus;

/**
 * Created by yohel on 27/02/16.
 */
import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}