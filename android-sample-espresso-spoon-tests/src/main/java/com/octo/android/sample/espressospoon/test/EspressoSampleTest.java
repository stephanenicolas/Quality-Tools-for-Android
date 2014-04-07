package com.octo.android.sample.espressospoon.test;

import android.test.ActivityInstrumentationTestCase2;

import com.octo.android.sample.R;
import com.octo.android.sample.ui.HelloAndroidActivity;
import com.squareup.spoon.Spoon;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class EspressoSampleTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public EspressoSampleTest() {
        super(HelloAndroidActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCompute() throws Exception {
        onView(withId(R.id.button_main)).check(matches(withText("Click !")));
        // given
        Spoon.screenshot(getActivity(), "initial_state");

        // when
        onView(withId(R.id.button_main)).perform(click());

        // then
        Spoon.screenshot(getActivity(), "button_clicked");
        onView(withId(R.id.textview_hello)).check(matches(withText("42")));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
