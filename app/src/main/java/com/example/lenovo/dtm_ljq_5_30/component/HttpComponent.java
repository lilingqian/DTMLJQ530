package com.example.lenovo.dtm_ljq_5_30.component;

import com.example.lenovo.dtm_ljq_5_30.MainActivity;
import com.example.lenovo.dtm_ljq_5_30.module.HttpModule;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(MainActivity mainActivity);
}
