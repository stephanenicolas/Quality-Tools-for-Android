package com.octo.android.sample.uitest;

import android.test.FlakyTest;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.github.rtyley.android.screenshot.celebrity.Screenshots;

/**
 * A working example of a ui automator test.
 * @author SNI
 */
public class UIAutomatorSampleTest extends UiAutomatorTestCase {

    private static final int TIMEOUT_DURING_APP_SEARCH = 10000;
    private static final int TEST_TOLERANCE = 3;
    private static final int MAX_SEARCH_SWIPES_IN_APP_MENU = 15;
    private static final long CALCULATOR_UPDATE_TIMEOUT = 500;

    private String currentTestName;
    private int currentScreenshotIndex;

    private void takeScreenshot(String name) {
        getUiDevice().waitForIdle();
        Screenshots.poseForScreenshotNamed(currentTestName + "_" + currentScreenshotIndex++ + "_" + name);
    }

    private void setCurrentTestName(String testName) {
        this.currentScreenshotIndex = 0;
        this.currentTestName = testName;
        takeScreenshot("start");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        unlockEmulator();
    }

    @Override
    protected void tearDown() throws Exception {
        takeScreenshot("end");
        // Simulate a short press on the HOME button.
        getUiDevice().pressHome();
        super.tearDown();
    }

    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testSettingsApp() throws UiObjectNotFoundException {
        setCurrentTestName("testSettingsApp");
        startAppOnEmulator("Settings");

        takeScreenshot("open");

        // Validate that the package name is the expected one
        UiObject settingsValidation = new UiObject(new UiSelector().packageName("com.android.settings"));
        assertTrue("Unable to detect Settings", settingsValidation.exists());
    }

    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testCalculatorApp() throws UiObjectNotFoundException {
        setCurrentTestName("testCalculatorApp");

        startAppOnEmulator("Calculator");

        takeScreenshot("open");

        UiObject deleteButton;

        deleteButton = new UiObject(new UiSelector().text("DELETE"));
        deleteButton.waitForExists(CALCULATOR_UPDATE_TIMEOUT);
        if (!deleteButton.exists()) {
            deleteButton = new UiObject(new UiSelector().text("CLR"));
        }
        deleteButton.waitForExists(CALCULATOR_UPDATE_TIMEOUT);
        deleteButton.click();

        takeScreenshot("after_clear");

        new UiObject(new UiSelector().text("7")).click();
        new UiObject(new UiSelector().text("+")).click();
        new UiObject(new UiSelector().text("5")).click();
        new UiObject(new UiSelector().text("=")).click();
        assertTrue(new UiObject(new UiSelector().text("12")).waitForExists(CALCULATOR_UPDATE_TIMEOUT));
    }

    private void startAppOnEmulator(String appName) throws UiObjectNotFoundException {
        // Simulate a short press on the HOME button.
        getUiDevice().pressHome();

        new UiObject(new UiSelector().description("Apps"));

        // We?re now in the home screen. Next, we want to simulate
        // a user bringing up the All Apps screen.
        // If you use the uiautomatorviewer tool to capture a snapshot
        // of the Home screen, notice that the All Apps button?s
        // content-description property has the value ?Apps?. We can
        // use this property to create a UiSelector to find the button.
        UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));

        // Simulate a click to bring up the All Apps screen.
        allAppsButton.clickAndWaitForNewWindow();

        // In the All Apps screen, the Settings app is located in
        // the Apps tab. To simulate the user bringing up the Apps tab,
        // we create a UiSelector to find a tab with the text
        // label ?Apps?.
        UiObject appsTab = new UiObject(new UiSelector().text("Apps"));

        // Simulate a click to enter the Apps tab.
        appsTab.click();

        // Next, in the apps tabs, we can simulate a user swiping until
        // they come to the Settings app icon. Since the container view
        // is scrollable, we can use a UiScrollable object.
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));

        // Set the swiping mode to horizontal (the default is vertical)
        appViews.setAsHorizontalList();
        appViews.setMaxSearchSwipes(MAX_SEARCH_SWIPES_IN_APP_MENU);

        // Create a UiSelector to find the Settings app and simulate
        // a user click to launch the app.
        UiObject settingsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), appName);
        settingsApp.waitForExists(TIMEOUT_DURING_APP_SEARCH);
        settingsApp.clickAndWaitForNewWindow();
    }

    private void unlockEmulator() {
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_SOFT_LEFT);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_SOFT_RIGHT);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_MENU);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_MENU);
    }
}
