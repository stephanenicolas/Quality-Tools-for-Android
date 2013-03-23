package com.octo.android.sample.test;

import org.easymock.EasyMock;
import org.mockito.Mockito;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.TextView;

import com.octo.android.sample.R;
import com.octo.android.sample.model.Computer;
import com.octo.android.sample.model.DummyComputer;
import com.octo.android.sample.ui.HelloAndroidActivity;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class);
    }

    public void testActivity_not_null() {
        assertNotNull(getActivity());
    }

    @UiThreadTest
    public void testActivity_shouldUseCustomComputerUsingEasyMock() throws Exception {
        final int EXPECTED_RESULT = 1;
        // given
        HelloAndroidActivity activityUnderTest = getActivity();
        Computer mockComputer = EasyMock.createMock(DummyComputer.class);
        EasyMock.expect(mockComputer.getResult()).andReturn(EXPECTED_RESULT);
        activityUnderTest.setComputer(mockComputer);
        EasyMock.replay(mockComputer);

        // when
        Button button = (Button) activityUnderTest.findViewById(R.id.button_main);
        button.performClick();

        // then
        EasyMock.verify(mockComputer);
        TextView textViewHello = (TextView) activityUnderTest.findViewById(R.id.textview_hello);
        String textViewHelloString = textViewHello.getText().toString();
        assertEquals(textViewHelloString, String.valueOf(EXPECTED_RESULT));
    }

    @UiThreadTest
    public void testActivity_shouldUseCustomComputerUsingMockito() throws Exception {
        final int EXPECTED_RESULT = 1;
        // given
        HelloAndroidActivity activityUnderTest = getActivity();

        Computer mockComputer = Mockito.mock(Computer.class);
        Mockito.when(mockComputer.getResult()).thenReturn(EXPECTED_RESULT);
        activityUnderTest.setComputer(mockComputer);

        // when
        Button button = (Button) activityUnderTest.findViewById(R.id.button_main);
        button.performClick();

        // then
        Mockito.verify(mockComputer, Mockito.times(1)).getResult();
        TextView textViewHello = (TextView) activityUnderTest.findViewById(R.id.textview_hello);
        String textViewHelloString = textViewHello.getText().toString();
        assertEquals(textViewHelloString, String.valueOf(EXPECTED_RESULT));
    }

}
