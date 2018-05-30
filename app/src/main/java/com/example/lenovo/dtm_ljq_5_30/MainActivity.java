package com.example.lenovo.dtm_ljq_5_30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.dtm_ljq_5_30.bean.BaseBean;
import com.example.lenovo.dtm_ljq_5_30.component.DaggerHttpComponent;
import com.example.lenovo.dtm_ljq_5_30.module.HttpModule;
import com.example.lenovo.dtm_ljq_5_30.ui.BaseActivity;
import com.example.lenovo.dtm_ljq_5_30.ui.ListAdapter;
import com.example.lenovo.dtm_ljq_5_30.ui.duotiaomu.ListContract;
import com.example.lenovo.dtm_ljq_5_30.ui.duotiaomu.ListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

public class MainActivity extends BaseActivity<ListPresenter> implements ListContract.View{

    private LinearLayout ll;
    private RecyclerView rv;
    private int type = 1;
    private int page = 1;
    private SmartRefreshLayout smart_refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mPresenter.onSuccess(type,page);

        smart_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                mPresenter.onSuccess(type,page);
                smart_refresh.finishLoadMore(2000);

            }
        });
        smart_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page++;
                mPresenter.onSuccess(type,page);
                smart_refresh.finishRefresh(2000);
            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }



    private void initView() {
        ll = (LinearLayout) findViewById(R.id.ll);
        rv = (RecyclerView) findViewById(R.id.rv);
        smart_refresh = (SmartRefreshLayout) findViewById(R.id.smart_refresh);
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        List<BaseBean.DataBean> data=baseBean.getData();
        ListAdapter adapter=new ListAdapter(this,data);
        rv.setAdapter(adapter);
    }
}
