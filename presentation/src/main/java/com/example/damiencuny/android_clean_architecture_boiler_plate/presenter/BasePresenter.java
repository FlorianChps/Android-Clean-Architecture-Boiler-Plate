package com.example.damiencuny.android_clean_architecture_boiler_plate.presenter;

public interface BasePresenter<T> {

    void onViewAttached(T view);

    void onViewDetached();

    void onDestroy();

}
