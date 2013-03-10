package com.octo.android.sample.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.octo.android.sample.R;
import com.octo.android.sample.ui.HelloAndroidActivity;
import com.squareup.spoon.Spoon;

public class HelloAndroidActivitySpoonTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {
    private Solo solo;
    private TextView textView;

    public HelloAndroidActivitySpoonTest() {
        super(HelloAndroidActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        textView = (TextView) getActivity().findViewById(R.id.textview_hello);
    }

    public void testCompute() throws Exception {
        // given
        Spoon.screenshot(getActivity(), "initial_state");

        // when
        solo.clickOnButton("Click !");

        // then
        Spoon.screenshot(getActivity(), "button_clicked");
        assertEquals("42", textView.getText().toString());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
