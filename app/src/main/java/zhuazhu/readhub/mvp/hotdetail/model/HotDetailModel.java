package zhuazhu.readhub.mvp.hotdetail.model;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.data.db.model.HotNews_Table;
import zhuazhu.readhub.data.net.ReadService;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;

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

    @Override
    public boolean isCollectedById(String id) {
        HotNews hotNews = SQLite.select().from(HotNews.class).where(HotNews_Table.id.eq(id)).querySingle();
        return hotNews!=null?true:false;
    }

    @Override
    public void saveHotNewsToDb(HotNews hotNews) {
        hotNews.save();
    }

    @Override
    public void deleteHotNewsFromDbById(String id) {
        SQLite.delete().from(HotNews.class).where(HotNews_Table.id.is(id)).execute();
    }
}
