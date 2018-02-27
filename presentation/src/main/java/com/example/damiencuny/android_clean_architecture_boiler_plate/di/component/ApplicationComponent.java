package com.example.damiencuny.android_clean_architecture_boiler_plate.di.component;

import com.example.damiencuny.android_clean_architecture_boiler_plate.di.module.ApplicationModule;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    MainComponent plus(MainModule module);

}
