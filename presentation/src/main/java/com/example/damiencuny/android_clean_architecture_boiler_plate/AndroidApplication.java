package com.example.damiencuny.android_clean_architecture_boiler_plate;

import android.app.Application;

import com.crashlytics.android.core.CrashlyticsCore;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.component.ApplicationComponent;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.component.DaggerApplicationComponent;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.module.ApplicationModule;

import io.fabric.sdk.android.Fabric;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build());

        initDI();
    }

    private void initDI() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
