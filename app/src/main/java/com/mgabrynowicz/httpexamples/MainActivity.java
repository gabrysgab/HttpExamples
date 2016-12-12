package com.mgabrynowicz.httpexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView progressBar;
    private ProgressBar realProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ImageView) findViewById(R.id.progressBar);
        realProgressBar = (ProgressBar) findViewById(R.id.realProgressBar);


        TestAsyncTask asyncTask = new TestAsyncTask(textView, progressBar, realProgressBar);

       asyncTask.execute(5000);

    }
}
