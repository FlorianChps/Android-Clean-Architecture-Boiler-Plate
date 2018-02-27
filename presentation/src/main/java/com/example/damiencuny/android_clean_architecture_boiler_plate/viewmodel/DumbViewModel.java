package com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel;

public class DumbViewModel {

    private String name;

    public DumbViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
