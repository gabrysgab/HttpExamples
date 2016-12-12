package com.mgabrynowicz.httpexamples;

import android.app.IntentService;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

/**
 * Created by RENT on 2016-12-12.
 */

public class TestIntentService extends IntentService {

    public TestIntentService() {
        super("TestIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {

        ServerApiClient serverApiClient = new ServerApiClient();
        try {
            String result = serverApiClient.callServerApi();
            postResult(result);

        } catch (IOException e) {
            e.printStackTrace();
            postResult(null);
        }
    }

    private void postResult(String result) {
        OperationCompletedEvent event = new OperationCompletedEvent(result);

        EventBus.getDefault().post(event);
    }
}
