package com.nativemodules;

import android.annotation.SupperessLint;
import android.provider.Settings;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;

public class ReactOneCustomMethod extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    ReactOneCustomMethod(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ReactOneCustomMethod";
    }

    @ReactMethod
    public void getPhoneID(Promise response) {
        try {
            @SupperessLint("HardwareIds") String id = Settings.Secure.getString(reactContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        catch (Exception e) {
            response.reject("Error", e);
        }
    }
}