package com.example.lenovo.dtm_ljq_5_30.net;

import com.example.lenovo.dtm_ljq_5_30.bean.BaseBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ListApiService {


    @GET("satinApi")
    Observable<BaseBean> doGet(@QueryMap Map<String,String> map);

}
