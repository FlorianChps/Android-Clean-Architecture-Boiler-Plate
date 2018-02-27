package com.example.data.model.mapper;

import com.example.data.model.DumbEntity;
import com.example.domain.model.DumbModel;

public class DumbEntityMapper {

    public static DumbModel convertToModel(DumbEntity dumbEntity) {
        return new DumbModel(
                dumbEntity.getName()
        );
    }
}
