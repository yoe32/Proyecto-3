package com.example.jazmin.androidrestclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class AndroidRESTClientActivity extends AppCompatActivity {

    private static final String SERVICE_URL = "http://192.1.9:8080/RestWebServiceDemo/rest/person";
    private static final String TAG = "AndroidRESTClientActivity";

    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_restclient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void retrieveSampleData(View view)
    {
        String sampleURL = SERVICE_URL + "/sample";
        //WebServiceTask wst = new WebServiceTask(WebServiceTask.GET_TASK, this, "GETting data...");
    }

}
