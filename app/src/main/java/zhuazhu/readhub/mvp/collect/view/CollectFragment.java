package zhuazhu.readhub.mvp.collect.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.app.ReadHubApp;
import zhuazhu.readhub.di.module.CollectModule;
import zhuazhu.readhub.mvp.base.fragment.BaseFragment;
import zhuazhu.readhub.mvp.base.fragment.BasePresenterFragment;
import zhuazhu.readhub.mvp.collect.CollectContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;
import zhuazhu.readhub.mvp.web.WebActivity;

/**
 * @author zhuazhu
 */
public class CollectFragment extends BasePresenterFragment<CollectContract.Presenter> implements CollectContract.View {
    private static final String TAG = "CollectFragment";
    public static CollectFragment newInstance(){
        CollectFragment collectFragment = new CollectFragment();
        collectFragment.setArguments(new Bundle());
        return collectFragment;
    }
    public String getFragmentTag(){
        return TAG;
    }
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @Override
    protected int getlayoutId() {
        return R.layout.fragment_collect;
    }


    @Override
    protected void initParam() {

    }

    @Override
    protected void injectComponent() {
        ReadHubApp.getAppComponent().collectComponent(new CollectModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mPresenter.queryHotNewsFromDb());
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.queryHotNewsFromDb();
    }

    @Override
    public void initAdapter(HotAdapter hotAdapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mBaseActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(hotAdapter);
    }

    @Override
    public void finishRefresh() {
        mRefreshLayout.finishRefresh();
    }
}
