package com.mgabrynowicz.httpexamples;

/**
 * Created by RENT on 2016-12-12.
 */

public class OperationCompletedEvent {
    private final String result;

    public OperationCompletedEvent(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
