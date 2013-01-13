package com.octo.android.sample.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.octo.android.sample.HelloAndroidActivity;
import com.octo.android.sample.R;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {
    @Test
    public void shouldHaveApplicationName() throws Exception {
        String appName = new HelloAndroidActivity().getResources().getString(
            R.string.app_name);
        assertThat(appName, equalTo("sonar-android-sample"));
    }
}
