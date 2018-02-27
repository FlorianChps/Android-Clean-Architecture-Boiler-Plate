package com.example.domain.usecase.main;

import com.example.domain.model.DumbModel;

import io.reactivex.Single;

public interface IMainUseCase {

    Single<DumbModel> getModel();

}
