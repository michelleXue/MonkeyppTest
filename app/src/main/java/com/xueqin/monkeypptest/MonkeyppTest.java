package com.xueqin.monkeypptest;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonkeyppTest {
    public final String TAG = "UiAutomatorExample";

    @Before
    public void setUp() {
        Log.d(TAG, "Before");
        System.out.println("Before");
    }

    @Test
    public void test() {
        Log.d(TAG, "Test");
        System.out.println("Test");
    }

    @After
    public void tearDown() {
        Log.d(TAG, "After");
        System.out.println("After");
    }
}
