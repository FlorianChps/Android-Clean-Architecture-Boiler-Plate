package com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread;

import io.reactivex.Scheduler;

public interface ISchedulerProvider {

    Scheduler getWorkerThread();

    Scheduler getCallbackThread();
}
