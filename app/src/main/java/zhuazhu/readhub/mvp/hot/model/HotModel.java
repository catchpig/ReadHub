package zhuazhu.readhub.mvp.hot.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.hot.HotContract;
import zhuazhu.readhub.data.net.ReadService;
import zhuazhu.readhub.utils.RxSchedulersHelper;

/**
 * @author zhuazhu
 **/
public class HotModel implements HotContract.Model {
    private final ReadService mReadService;
    private final ReadHubCacheProviders mCacheProviders;
//Method threw 'java.lang.IllegalArgumentException' exception. Cannot evaluate $Proxy5.toString()
    @Inject
    public HotModel(ReadService readService,ReadHubCacheProviders readHubCacheProviders) {
        mReadService = readService;
        mCacheProviders = readHubCacheProviders;
    }

    @Override
    public Observable<List<HotNews>> queryHot(String lastCursor) {
        Observable<List<HotNews>> observable = RxSchedulersHelper.transform(mReadService.queryHotNews(lastCursor));
        return mCacheProviders
                .queryHotNews(observable,new DynamicKey(lastCursor));
    }
}
