package com.mgabrynowicz.httpexamples;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by RENT on 2016-12-12.
 */

public class TestAsyncTask extends AsyncTask<Integer, Integer, String> {

    private final TextView textView;
    private ImageView progressBar;
    private ProgressBar realProgressBar;
    private ServerApiClient serverApiClient;


    public TestAsyncTask(TextView textView, ImageView progressBar, ProgressBar realProgressBar) {

        this.textView = textView;
        this.progressBar = progressBar;
        this.realProgressBar = realProgressBar;
        this.serverApiClient = new ServerApiClient();


    }

    @Override
    protected void onPreExecute() {
        textView.setText("start");
    }

    @Override
    protected void onPostExecute(String result) {

        if(result == null) {
            textView.setText("FAIL");
            return;
        }
        textView.setText("DONE " + result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int currentProgress = values[0];
        textView.setText(String.valueOf(currentProgress));
        progressBar.getLayoutParams().width = (currentProgress)*10;
        realProgressBar.setProgress(currentProgress);
    }


    @Override
    protected String doInBackground(Integer... integers) {
        try {
            return serverApiClient.callServerApi();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
