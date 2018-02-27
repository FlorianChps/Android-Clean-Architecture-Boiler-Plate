package com.example.damiencuny.android_clean_architecture_boiler_plate;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class DebugApplication extends AndroidApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        initDevSdk();
    }

    private void initDevSdk() {
        Stetho.initializeWithDefaults(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
