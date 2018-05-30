package com.example.lenovo.dtm_ljq_5_30.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.dtm_ljq_5_30.inter.IBase;

import javax.inject.Inject;

public  abstract   class BaseActivity<T extends BaseContract.BasePresenter>extends AppCompatActivity implements IBase,BaseContract.BaseView{

    @Inject
     protected  T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();
        mPresenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }
}
