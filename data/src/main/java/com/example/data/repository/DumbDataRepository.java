package com.example.data.repository;

import android.content.Context;

import com.example.data.R;
import com.example.data.model.DumbEntity;
import com.example.data.model.mapper.DumbEntityMapper;
import com.example.domain.model.DumbModel;
import com.example.domain.repository.DumbRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class DumbDataRepository implements DumbRepository {

    private final Context context;

    @Inject
    DumbDataRepository(Context context) {
        this.context = context;
    }

    @Override
    public Single<DumbModel> getModel() {
        return Single.create(emitter -> {
            final DumbEntity dumbEntity = new DumbEntity(context.getString(R.string.hello_message));

            emitter.onSuccess(DumbEntityMapper.convertToModel(dumbEntity));
        });
    }
}
