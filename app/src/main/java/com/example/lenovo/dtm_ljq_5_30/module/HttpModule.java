package com.example.lenovo.dtm_ljq_5_30.module;

import com.example.lenovo.dtm_ljq_5_30.net.ListApi;
import com.example.lenovo.dtm_ljq_5_30.net.ListApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS);
    }
    @Provides
    ListApi provideListApi(OkHttpClient.Builder builder){

        ListApiService listApiService = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
                .create(ListApiService.class);

        return ListApi.getListApi(listApiService);

    }
}
