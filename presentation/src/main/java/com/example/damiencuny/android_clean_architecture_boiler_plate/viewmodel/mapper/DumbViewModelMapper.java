package com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel.mapper;

import com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel.DumbViewModel;
import com.example.domain.model.DumbModel;

public class DumbViewModelMapper {

    public static DumbViewModel convertToViewModel(DumbModel dumbModel) {
        return new DumbViewModel(
                dumbModel.getName()
        );
    }
}
