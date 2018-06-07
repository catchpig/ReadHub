package zhuazhu.readhub.mvp.hotdetail.model;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.data.net.ReadService;

/**
 * @author zhuazhu
 **/
public class HotDetailModel implements HotDetailContract.Model {
    private final ReadService mReadService;
    private final ReadHubCacheProviders mCacheProviders;

    @Inject
    public HotDetailModel(ReadService readService,ReadHubCacheProviders readHubCacheProviders) {
        mReadService = readService;
        mCacheProviders = readHubCacheProviders;
    }

    @Override
    public Observable<HotNews> queryDetail(String topicId) {
        Observable<HotNews> observable = mReadService
                .queryHotNewsDetail(topicId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return mCacheProviders.queryHotNewsDetail(observable,new DynamicKey(topicId));
    }
}
