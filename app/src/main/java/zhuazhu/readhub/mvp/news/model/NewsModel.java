package zhuazhu.readhub.mvp.news.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;
import zhuazhu.readhub.mvp.news.contract.NewsContract;
import zhuazhu.readhub.data.net.ReadService;
import zhuazhu.readhub.utils.RxSchedulersHelper;

/**
 * @author zhuazhu
 **/
public class NewsModel implements NewsContract.Model {
    private final ReadService mReadService;
    private final ReadHubCacheProviders mCacheProviders;

    @Inject
    public NewsModel(ReadService readService,ReadHubCacheProviders readHubCacheProviders) {
        mReadService = readService;
        mCacheProviders = readHubCacheProviders;
    }

    @Override
    public Observable<List<News>> queryScienceNews(String lastCursor) {
        Observable<List<News>> observable = RxSchedulersHelper.transform(mReadService.queryScienceNews(lastCursor));
        return mCacheProviders.queryScienceNews(observable,new DynamicKey(lastCursor));
    }

    @Override
    public Observable<List<News>> queryDeveloperNews(String lastCursor) {
        Observable<List<News>> observable = RxSchedulersHelper.transform(mReadService.queryDevelopNews(lastCursor));
        return mCacheProviders.queryDevelopNews(observable,new DynamicKey(lastCursor));
    }

    @Override
    public Observable<List<News>> queryChainNews(String lastCursor) {
        Observable<List<News>> observable = RxSchedulersHelper.transform(mReadService.queryBlockchainNews(lastCursor));
        return mCacheProviders.queryBlockchainNews(observable,new DynamicKey(lastCursor));
    }
}
