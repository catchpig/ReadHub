package zhuazhu.readhub.mvp.hotdetail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhuazhu.readhub.R;
import zhuazhu.readhub.app.ReadHubApp;
import zhuazhu.readhub.di.module.HotDetailModule;
import zhuazhu.readhub.mvp.base.activity.BasePresenterActivity;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;

public class HotDetailActivity extends BasePresenterActivity<HotDetailContract.Presenter> implements HotDetailContract.View {
    private static final String NEWS_ID = "news_id";

    public static void start(Context context, String id) {
        Intent intent = new Intent(context, HotDetailActivity.class);
        intent.putExtra(NEWS_ID, id);
        context.startActivity(intent);
    }
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.content)
    TextView mContent;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.index_news)
    TextView mIndexNews;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Override
    protected int getlayoutId() {
        return R.layout.activity_hot_detail;
    }

    private String mTopicId;

    @Override
    protected void initParam() {
        Intent intent = getIntent();
        mTopicId = intent.getStringExtra(NEWS_ID);
    }

    @Override
    protected void injectComponent() {
        ReadHubApp.getAppComponent().hotDetailComponent(new HotDetailModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        mPresenter.queryDetail(mTopicId);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndexNews(String.format("左右滑动查看更多%d/%d",(position+1),mPresenter.getPageSize()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setIndexNews(String indexNews) {
        mIndexNews.setText(indexNews);
    }

    @Override
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void setContent(String content) {
        mContent.setText(content);
    }

    @Override
    public void initAdapter(TimeLineAdapter timeLineAdapter, NewsPageAdapter newsPageAdapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(timeLineAdapter);

        mViewPager.setAdapter(newsPageAdapter);
    }
}
