package com.example.damiencuny.android_clean_architecture_boiler_plate.di.module;

import android.app.Application;
import android.content.Context;

import com.example.data.repository.DumbDataRepository;
import com.example.domain.repository.DumbRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context getContext() {
        return application;
    }

    @Provides
    @Singleton
    DumbRepository provideDumbRepository(DumbDataRepository dumbDataRepository) {
        return dumbDataRepository;
    }
}
