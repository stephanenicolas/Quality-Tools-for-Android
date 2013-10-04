package com.octo.android.sample.test;

import org.boundbox.BoundBox;

import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;

import com.octo.android.sample.ui.BoundBoxOfHelloAndroidActivity;
import com.octo.android.sample.ui.HelloAndroidActivity;

public class HelloAndroidActivityBoundBoxTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    @BoundBox(boundClass=HelloAndroidActivity.class, maxSuperClass=FragmentActivity.class)
    private BoundBoxOfHelloAndroidActivity boundBoxOfHelloAndroidActivity;
    
    public HelloAndroidActivityBoundBoxTest() {
        super(HelloAndroidActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        boundBoxOfHelloAndroidActivity = new BoundBoxOfHelloAndroidActivity(getActivity());
    }

    @UiThreadTest
    public void testCompute() throws Exception {
        boundBoxOfHelloAndroidActivity.boundBox_getButton().performClick();
        assertTrue(boundBoxOfHelloAndroidActivity.boundBox_getTextView().getText().equals("42"));
    }

}
