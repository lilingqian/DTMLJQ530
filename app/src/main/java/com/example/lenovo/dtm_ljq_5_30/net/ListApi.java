package com.example.lenovo.dtm_ljq_5_30.net;

import com.example.lenovo.dtm_ljq_5_30.bean.BaseBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class ListApi {

    private  static ListApi listApi;

    private ListApiService listApiService;

    public  ListApi(ListApiService listApiService){
        this.listApiService=listApiService;

    }

    public static  ListApi getListApi(ListApiService listApiService){

        if (listApi==null){

             listApi = new ListApi(listApiService);
        }
        return listApi;

    }

    public Observable<BaseBean> getList(int type ,int page){

        Map<String,String> params=new HashMap<>();
        params.put("type",String.valueOf(type));
        params.put("page",String.valueOf(page));

        return listApiService.doGet(params);
    }
}
