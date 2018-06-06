package zhuazhu.readhub.mvp.hotdetail.presenter;

import io.reactivex.functions.Consumer;
import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.mvp.base.adapter.RecyclerAdapter;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;
import zhuazhu.readhub.mvp.hotdetail.model.HotDetailModel;
import zhuazhu.readhub.mvp.hotdetail.model.HotTimeLine;
import zhuazhu.readhub.mvp.hotdetail.view.HotDetailActivity;
import zhuazhu.readhub.mvp.news.model.News;
import zhuazhu.readhub.mvp.web.WebActivity;

/**
 * @author zhuazhu
 **/
public class HotDetailPresenter extends BasePresenter<HotDetailContract.View> implements HotDetailContract.Presenter {
    private final HotDetailContract.Model mModel;
    private final TimeLineAdapter mTimeLineAdapter;
    private final NewsPageAdapter mNewsPageAdapter;
    public HotDetailPresenter(HotDetailContract.View view,HotDetailModel hotDetailModel,TimeLineAdapter timeLineAdapter,NewsPageAdapter newsPageAdapter) {
        super(view);
        mModel = hotDetailModel;
        mTimeLineAdapter = timeLineAdapter;
        mNewsPageAdapter = newsPageAdapter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView.initAdapter(mTimeLineAdapter,mNewsPageAdapter);
        mTimeLineAdapter.setOnItemClickListener((hotTimeLine, position) -> {
            HotDetailActivity.start(mView.getBaseActivity(),hotTimeLine.getId());
        });
        mNewsPageAdapter.setOnItemClickListener((news, position) -> {
            WebActivity.start(mView.getBaseActivity(),news.getMobileUrl());
        });
    }

    @Override
    public void queryDetail(String topicId) {
        mModel.queryDetail(topicId).subscribe(hotNews -> {
            mView.setTitle(hotNews.getTitle());
            mView.setContent(hotNews.getSummary());
            mTimeLineAdapter.setData(hotNews.getTimeline().getTopics());
            mNewsPageAdapter.setData(hotNews.getNewsArray());
            mView.setIndexNews(String.format("左右滑动查看更多1/%d",getPageSize()));
        });
    }

    @Override
    public int getPageSize() {
        return mNewsPageAdapter.getCount();
    }
}
