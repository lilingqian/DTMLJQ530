package com.example.lenovo.dtm_ljq_5_30.ui.duotiaomu;

import com.example.lenovo.dtm_ljq_5_30.bean.BaseBean;
import com.example.lenovo.dtm_ljq_5_30.ui.BaseContract;

public  interface ListContract {

    interface  View  extends BaseContract.BaseView{

        void onSuccess(BaseBean baseBean);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{

        void onSuccess(int type, int page);
    }
}
