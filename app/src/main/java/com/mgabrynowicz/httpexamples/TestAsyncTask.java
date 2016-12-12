package com.mgabrynowicz.httpexamples;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by RENT on 2016-12-12.
 */

public class TestAsyncTask extends AsyncTask<Integer, Integer, String> {

    private final TextView textView;
    private ImageView progressBar;
    private ProgressBar realProgressBar;


    public TestAsyncTask(TextView textView, ImageView progressBar, ProgressBar realProgressBar) {

        this.textView = textView;
        this.progressBar = progressBar;
        this.realProgressBar = realProgressBar;

    }

    @Override
    protected void onPreExecute() {
        textView.setText("start");
    }

    @Override
    protected void onPostExecute(String result) {
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
            int timeout = integers[0];
            Thread.sleep(timeout);
            for (int i = 0; i < 100; i++) {

                this.publishProgress(i);
                Thread.sleep(timeout / 100);
            }
            return String.valueOf(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
