package com.octo.android.sample;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {
    @Test
    public void shouldHaveApplicationName() throws Exception {
        HelloAndroidActivity activityUnderTest = new HelloAndroidActivity();
        activityUnderTest.onCreate(null);
        String appName = activityUnderTest.getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("sonar-android-sample"));
    }
}
