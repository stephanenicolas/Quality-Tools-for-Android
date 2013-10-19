package com.octo.android.sample.espresso.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import android.test.ActivityInstrumentationTestCase2;

import com.octo.android.sample.R;
import com.octo.android.sample.ui.HelloAndroidActivity;

/**
 * A working example of an espresso test.
 * @author SNI
 */
public class EspressoSampleTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public EspressoSampleTest() {
        super(HelloAndroidActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testClick() {
        onView(withId(R.id.button_main))
        .check(matches(withText("Click !")));

        onView(withId(R.id.button_main))
        .perform(click());
        
        onView(withId(R.id.textview_hello))
        .check(matches(withText("42")));
        
    }

}
