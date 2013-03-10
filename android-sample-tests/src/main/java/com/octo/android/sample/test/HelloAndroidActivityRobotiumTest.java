package com.octo.android.sample.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;
import com.octo.android.sample.ui.HelloAndroidActivity;

public class HelloAndroidActivityRobotiumTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {
    private Solo solo;

    public HelloAndroidActivityRobotiumTest() {
        super("com.octo.android.sample", HelloAndroidActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testCompute() throws Exception {
        solo.clickOnButton("Click !");
        Assert.assertTrue(solo.searchText("42"));
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
