package com.mgabrynowicz.httpexamples;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by RENT on 2016-12-12.
 */

public class ServerApiClient {
    public String callServerApi() throws IOException {

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            URL url = new URL("http://www.android.com");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            inputStream = httpURLConnection.getInputStream();
            return IOUtils.toString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}

