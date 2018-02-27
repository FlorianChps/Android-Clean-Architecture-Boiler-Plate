package com.example.domain.repository;

import com.example.domain.model.DumbModel;

import io.reactivex.Single;

public interface DumbRepository {

    Single<DumbModel> getModel();

}
