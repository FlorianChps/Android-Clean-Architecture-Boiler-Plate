package com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread.impl;

import com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements ISchedulerProvider {

    @Inject
    public SchedulerProvider() {
    }

    @Override
    public Scheduler getWorkerThread() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getCallbackThread() {
        return AndroidSchedulers.mainThread();
    }
}
