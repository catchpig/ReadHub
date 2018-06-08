package zhuazhu.readhub.mvp.hotdetail.presenter;

import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;
import zhuazhu.readhub.mvp.hotdetail.model.HotDetailModel;
import zhuazhu.readhub.mvp.hotdetail.view.HotDetailActivity;
import zhuazhu.readhub.mvp.web.WebActivity;
import zhuazhu.readhub.data.net.HttpObservable;

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
    private HotNews mHotNews;
    @Override
    public void queryDetail(String topicId) {
        execute(mModel.queryDetail(topicId), new HttpObservable<HotNews>() {
            @Override
            public void onNext(HotNews hotNews) {
                mHotNews = hotNews;
                mView.setTitle(hotNews.getTitle());
                mView.setContent(hotNews.getSummary());
                mTimeLineAdapter.setData(hotNews.getTimeline().getTopics());
                mNewsPageAdapter.setData(hotNews.getNewsArray());
                mView.setIndexNews(String.format("左右滑动查看更多1/%d", getNewsPageSize()));
                boolean flag = mModel.queryHotNewsFromDb(hotNews.getId());
                mView.updateCollectImage(flag);
            }
        });
    }

    @Override
    public void collectHotNew() {
        boolean flag = mModel.queryHotNewsFromDb(mHotNews.getId());
        //TODO 需要删除数据和增加数据
        if(flag){

        }else{

        }
        mView.updateCollectImage(!flag);
    }

    @Override
    public int getNewsPageSize() {
        return mNewsPageAdapter.getCount();
    }
}
