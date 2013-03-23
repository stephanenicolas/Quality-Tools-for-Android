package com.octo.android.sample.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.octo.android.sample.R;
import com.octo.android.sample.ui.HelloAndroidActivity;

public class HelloAndroidActivityFestAndroidTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {
    private Solo solo;
    private TextView textView;

    public HelloAndroidActivityFestAndroidTest() {
        super(HelloAndroidActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        textView = (TextView) getActivity().findViewById(R.id.textview_hello);
    }

    public void testCompute() throws Exception {
        solo.clickOnButton("Click !");
        org.fest.assertions.api.ANDROID.assertThat(textView).containsText("42");
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
