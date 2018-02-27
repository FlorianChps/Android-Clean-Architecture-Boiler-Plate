package com.example.damiencuny.android_clean_architecture_boiler_plate.di.component;

import com.example.damiencuny.android_clean_architecture_boiler_plate.di.PerActivity;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.module.MainModule;
import com.example.damiencuny.android_clean_architecture_boiler_plate.view.activity.MainActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
