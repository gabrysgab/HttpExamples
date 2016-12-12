package com.mgabrynowicz.httpexamples;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by RENT on 2016-12-12.
 */

public class TestLoader implements LoaderManager.LoaderCallbacks<String> {

    private final TextView textView;
    private final Context context;

    public TestLoader(TextView textView, Context context) {

        this.textView = textView;
        this.context = context;
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new AsyncTaskLoader<String>(context) {

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                forceLoad();
            }

            public String loadInBackground() {
                try {
                    return new ServerApiClient().callServerApi();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
