package com.example.damiencuny.android_clean_architecture_boiler_plate.di.module;

import com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread.ISchedulerProvider;
import com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread.impl.SchedulerProvider;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.PerActivity;
import com.example.domain.usecase.main.IMainUseCase;
import com.example.domain.usecase.main.impl.MainUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @PerActivity
    ISchedulerProvider provideSchedulerBaseProvider(SchedulerProvider schedulerProvider) {
        return schedulerProvider;
    }

    @Provides
    @PerActivity
    IMainUseCase provideMainUseCase(MainUseCase mainUseCase) {
        return mainUseCase;
    }
}
