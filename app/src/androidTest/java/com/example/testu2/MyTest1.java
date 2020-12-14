package com.example.testu2;

import android.app.Instrumentation;
import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MyTest1 {
    public Instrumentation mInstrumentation;
    public UiDevice mUiDevice;

    @Before
    public void setUp(){
        mInstrumentation= InstrumentationRegistry.getInstrumentation();
        mUiDevice=UiDevice.getInstance(mInstrumentation);
    }

    @Test
    public void myDemo() throws RemoteException {
        mUiDevice.pressRecentApps();
    }
}
