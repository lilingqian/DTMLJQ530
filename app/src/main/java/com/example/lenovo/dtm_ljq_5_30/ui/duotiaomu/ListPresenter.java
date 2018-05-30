package com.example.lenovo.dtm_ljq_5_30.ui.duotiaomu;

import com.example.lenovo.dtm_ljq_5_30.bean.BaseBean;
import com.example.lenovo.dtm_ljq_5_30.net.ListApi;
import com.example.lenovo.dtm_ljq_5_30.ui.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ListPresenter extends BasePresenter<ListContract.View> implements ListContract.Presenter{

    private ListApi listApi;

    @Inject
    public  ListPresenter(ListApi listApi){
        this.listApi=listApi;
    }


    @Override
    public void onSuccess(int type, int page) {


        listApi.getList(type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {

                        mView.onSuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
