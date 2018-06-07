package zhuazhu.readhub.mvp.news.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jkb.fragment.rigger.annotation.LazyLoad;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import zhuazhu.readhub.R;
import zhuazhu.readhub.app.ReadHubApp;
import zhuazhu.readhub.di.module.NewsModule;
import zhuazhu.readhub.mvp.base.fragment.BasePresenterFragment;
import zhuazhu.readhub.mvp.news.adpter.NewsAdapter;
import zhuazhu.readhub.mvp.news.contract.NewsContract;

/**
 * @author zhuazhu
 **/
@LazyLoad
@Puppet
public class DeveloperFragment extends BasePresenterFragment<NewsContract.Presenter> implements NewsContract.View {
    private static final String TAG = "DeveloperFragment";
    public static DeveloperFragment newInstance() {
        DeveloperFragment developerFragment = new DeveloperFragment();
        developerFragment.setArguments(new Bundle());
        return developerFragment;
    }

    @BindView(R.id.refresh)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_developer;
    }

    public void onLazyLoadViewCreated(Bundle savedInstanceState) {
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void injectComponent() {
        ReadHubApp.getAppComponent().newsComponent(new NewsModule(this)).inject(this);
    }

    private String mLastCursor;

    @Override
    protected void initView() {

        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mLastCursor = "";
            mPresenter.queryDeveloperNews(mLastCursor);
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.queryDeveloperNews(mLastCursor);
        });
    }

    @Override
    public void initAdapter(NewsAdapter newsAdapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mBaseActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(newsAdapter);
    }

    @Override
    public void setLastCursor(String lastCursor) {
        mLastCursor = lastCursor;
        mRefreshLayout.finishRefresh(500);
        mRefreshLayout.finishLoadMore();
    }
}
