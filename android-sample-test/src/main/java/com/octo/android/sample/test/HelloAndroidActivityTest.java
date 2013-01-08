package com.octo.android.sample.test;

import android.test.ActivityInstrumentationTestCase2;
import com.octo.android.sample.HelloAndroidActivity;

public class HelloAndroidActivityTest extends
    ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super("com.octo.android.sample", HelloAndroidActivity.class);
    }

    public void testActivity_not_null() {
        assertNotNull(getActivity());
    }

}
