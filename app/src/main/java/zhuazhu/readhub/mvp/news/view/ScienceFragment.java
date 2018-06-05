package zhuazhu.readhub.mvp.news.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
public class ScienceFragment extends BasePresenterFragment<NewsContract.Presenter> implements NewsContract.View {
    private static ScienceFragment sScienceFragment;
    public static ScienceFragment newInstance(){
        if (sScienceFragment==null) {
            sScienceFragment = new ScienceFragment();
        }
        return sScienceFragment;
    }
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @Override
    protected int getlayoutId() {
        return R.layout.fragment_science;
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
        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mLastCursor = "";
            mPresenter.queryScienceNews(mLastCursor);
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mPresenter.queryScienceNews(mLastCursor);
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
