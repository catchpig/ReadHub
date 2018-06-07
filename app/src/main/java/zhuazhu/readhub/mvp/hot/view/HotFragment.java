package zhuazhu.readhub.mvp.hot.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jkb.fragment.rigger.annotation.Animator;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import zhuazhu.readhub.R;
import zhuazhu.readhub.app.ReadHubApp;
import zhuazhu.readhub.di.module.HotModule;
import zhuazhu.readhub.mvp.base.fragment.BasePresenterFragment;
import zhuazhu.readhub.mvp.hot.HotContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;

/**
 * @author zhuazhu
 */
public class HotFragment extends BasePresenterFragment<HotContract.Presenter> implements HotContract.View {
    private static final String TAG = "HotFragment";
    public static HotFragment newInstance(){
        HotFragment hotFragment = new HotFragment();
        hotFragment.setArguments(new Bundle());
        return hotFragment;
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
        return R.layout.fragment_hot;
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void injectComponent() {
        ReadHubApp.getAppComponent().hotComponent(new HotModule(this)).inject(this);
    }
    private String mLastCursor = "";

    @Override
    public void setLastCursor(String lastCursor) {
        mLastCursor = lastCursor;
        mRefreshLayout.finishRefresh(500);
        mRefreshLayout.finishLoadMore();
    }

    @Override
    protected void initView() {
        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mLastCursor = "";
            mPresenter.queryHotNews(mLastCursor);
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.queryHotNews(mLastCursor);
        });
    }

    @Override
    public void initAdapter(HotAdapter hotAdapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mBaseActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(hotAdapter);
    }
}
