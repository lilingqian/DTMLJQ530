package com.example.lenovo.dtm_ljq_5_30.ui;

public interface BaseContract {

    interface  BasePresenter< T extends  BaseView>{

        void attachView(T view);

        void detachView();


    }
    interface  BaseView{

       void showLoading();

       void dimissLoading();

    }
}
