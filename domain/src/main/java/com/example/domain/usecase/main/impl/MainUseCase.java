package com.example.domain.usecase.main.impl;

import com.example.domain.model.DumbModel;
import com.example.domain.repository.DumbRepository;
import com.example.domain.usecase.main.IMainUseCase;

import javax.inject.Inject;

import io.reactivex.Single;

public class MainUseCase implements IMainUseCase {

    private final DumbRepository dumbRepository;

    @Inject
    MainUseCase(DumbRepository dumbRepository) {
        this.dumbRepository = dumbRepository;
    }

    @Override
    public Single<DumbModel> getModel() {
        return dumbRepository.getModel();
    }
}
