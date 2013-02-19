package com.octo.android.sample.model;

public class DummyComputer implements Computer {

    private static final int RESULT = 42;

    @Override
    public int getResult() {
        return RESULT;
    }
}
