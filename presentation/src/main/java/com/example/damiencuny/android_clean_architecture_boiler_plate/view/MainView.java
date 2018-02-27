package com.example.damiencuny.android_clean_architecture_boiler_plate.view;

import com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel.DumbViewModel;

public interface MainView extends BaseView {

    void displayViewModel(DumbViewModel viewModel);

}
