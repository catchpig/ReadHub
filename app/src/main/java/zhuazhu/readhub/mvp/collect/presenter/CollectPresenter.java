package zhuazhu.readhub.mvp.collect.presenter;

import java.util.List;

import zhuazhu.readhub.aop.annotaion.SingleClick;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.mvp.base.adapter.RecyclerAdapter;
import zhuazhu.readhub.mvp.collect.CollectContract;
import zhuazhu.readhub.mvp.collect.model.CollectModel;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;
import zhuazhu.readhub.mvp.hotdetail.view.HotDetailActivity;
import zhuazhu.readhub.mvp.web.WebActivity;

/**
 * @author zhuazhu
 */
public class CollectPresenter extends BasePresenter<CollectContract.View> implements CollectContract.Presenter,RecyclerAdapter.OnItemClickListener<HotNews> {
    private final CollectContract.Model mCollectModel;
    private final HotAdapter mHotAdapter;
    public CollectPresenter(CollectContract.View view,CollectModel collectModel, HotAdapter hotAdapter) {
        super(view);
        mCollectModel = collectModel;
        mHotAdapter = hotAdapter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView.initAdapter(mHotAdapter);
        mHotAdapter.setOnItemClickListener(this);
    }

    @Override
    public void queryHotNewsFromDb() {
        List<HotNews> hotNewsList =  mCollectModel.queryHotNewsFromDb();
        mHotAdapter.setData(hotNewsList);
        mView.finishRefresh();
    }

    @SingleClick
    @Override
    public void onItemClick(HotNews hotNews, int position) {
        HotDetailActivity.start(mView.getBaseActivity(),hotNews.getId());
    }
}
