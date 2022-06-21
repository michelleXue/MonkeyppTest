package com.xueqin.monkeypptest;

import android.os.RemoteException;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MonkeyppTest {

    public final String TAG = "UiAutomatorExample";
    private static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice device;

    @Before
    public void setUp() {
        Log.d(TAG, "Before");

        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();
    }

    @Test
    public void test() throws UiObjectNotFoundException, InterruptedException, RemoteException {
        Log.d(TAG, "Test");
        System.out.println("Test");

        // Open apps list by scrolling on home screen
        UiObject workspace = device.findObject(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/workspace"));
        workspace.swipeUp(20);
        TimeUnit.SECONDS.sleep(1);

        // Click on Settings icon to launch the app
        UiObject settingButton = device.findObject(new UiSelector()
                .resourceId("com.google.android.apps.nexuslauncher:id/icon")
                .text("Settings"));
        settingButton.click();
        TimeUnit.SECONDS.sleep(1);

        // Wait up to 2 seconds for the element be displayed on screen
        UiObject2 networkAndInternet = device.wait(Until.findObject(By.text("Network & internet")), 2000);
        networkAndInternet.click();

        // Click on element with text "Wi‑Fi"
        UiObject2 wifi = device.wait(Until.findObject(By.text("Wi‑Fi")), 2000);
        wifi.click();

        TimeUnit.SECONDS.sleep(1);
        device.pressRecentApps();

//        // Click on element with text "Add network"
//        val addNetwork = device.wait(Until.findObject(By.text("Add network")), 2000)
//        addNetwork.click()
    }

    @After
    public void tearDown() {
        Log.d(TAG, "After");
        System.out.println("After");

        // go back home
        device.pressHome();
    }
}
