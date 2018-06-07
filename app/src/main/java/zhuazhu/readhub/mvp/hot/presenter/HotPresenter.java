package zhuazhu.readhub.mvp.hot.presenter;

import android.text.TextUtils;

import java.util.List;

import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.mvp.hot.HotContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;
import zhuazhu.readhub.mvp.hot.model.HotModel;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.view.HotDetailActivity;
import zhuazhu.readhub.net.HttpObservable;

/**
 * @author zhuazhu
 **/
public class HotPresenter extends BasePresenter<HotContract.View> implements HotContract.Presenter {
    private final HotContract.Model mHotModel;
    private final HotAdapter mHotAdapter;
    public HotPresenter(HotContract.View view,HotModel hotModel,HotAdapter hotAdapter) {
        super(view);
        mHotModel = hotModel;
        mHotAdapter = hotAdapter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView.initAdapter(mHotAdapter);
        mHotAdapter.setOnItemClickListener((hotNews, position) -> {
            HotDetailActivity.start(mView.getBaseActivity(),hotNews.getId());
        });
    }

    @Override
    public void queryHotNews(String lastCursor) {
        execute(mHotModel.queryHot(lastCursor), new HttpObservable<List<HotNews>>() {
            @Override
            public void onNext(List<HotNews> hotNews) {
                long order = hotNews.get(hotNews.size()-1).getOrder();
                mView.setLastCursor(String.valueOf(order));
                if (TextUtils.isEmpty(lastCursor)) {
                    mHotAdapter.setData(hotNews);
                }else{
                    mHotAdapter.addData(hotNews);
                }
            }
        });
    }
}
