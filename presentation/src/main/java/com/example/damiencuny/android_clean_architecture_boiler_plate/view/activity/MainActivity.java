package com.example.damiencuny.android_clean_architecture_boiler_plate.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.damiencuny.android_clean_architecture_boiler_plate.AndroidApplication;
import com.example.damiencuny.android_clean_architecture_boiler_plate.R;
import com.example.damiencuny.android_clean_architecture_boiler_plate.di.module.MainModule;
import com.example.damiencuny.android_clean_architecture_boiler_plate.presenter.main.MainPresenter;
import com.example.damiencuny.android_clean_architecture_boiler_plate.view.MainView;
import com.example.damiencuny.android_clean_architecture_boiler_plate.viewmodel.DumbViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDi();

        setContentView(R.layout.activity_main);

        bindView();
    }

    private void initDi() {
        ((AndroidApplication) getApplication()).getApplicationComponent()
                .plus(new MainModule())
                .inject(this);
    }

    private void bindView() {
        textView = findViewById(R.id.main_text_view);
    }

    @Override
    public void onStart() {
        super.onStart();
        mainPresenter.onViewAttached(this);
        mainPresenter.getViewModel();
    }

    @Override
    public void displayViewModel(DumbViewModel viewModel) {
        if (viewModel != null) {
            textView.setText(viewModel.getName());
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onStop() {
        mainPresenter.onViewDetached();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }
}
