package com.example.damiencuny.android_clean_architecture_boiler_plate.presenter.main;

import com.example.damiencuny.android_clean_architecture_boiler_plate.app.thread.ISchedulerProvider;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.PerActivity;
import com.example.damiencuny.android_clean_architecture_boiler_plate.presenter.BasePresenter;
import com.example.damiencuny.android_clean_architecture_boiler_plate.view.MainView;
import com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel.mapper.DumbViewModelMapper;
import com.example.domain.model.DumbModel;
import com.example.domain.usecase.main.IMainUseCase;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

@PerActivity
public class MainPresenter implements BasePresenter<MainView> {

    private final ISchedulerProvider schedulerProvider;
    private final IMainUseCase mainUseCase;

    private MainView view;

    @Inject
    public MainPresenter(
            ISchedulerProvider schedulerProvider,
            IMainUseCase mainUseCase) {
        this.schedulerProvider = schedulerProvider;
        this.mainUseCase = mainUseCase;
    }

    public void getViewModel() {
        mainUseCase.getModel()
                .subscribeOn(schedulerProvider.getWorkerThread())
                .observeOn(schedulerProvider.getCallbackThread())
                .subscribe(new SingleObserver<DumbModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(DumbModel dumbModel) {
                        if (view != null) {
                            view.displayViewModel(DumbViewModelMapper.convertToViewModel(dumbModel));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.onError("ERREUR");
                        }
                    }
                });
    }

    @Override
    public void onViewAttached(MainView view) {
        this.view = view;
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onDestroy() {

    }
}
