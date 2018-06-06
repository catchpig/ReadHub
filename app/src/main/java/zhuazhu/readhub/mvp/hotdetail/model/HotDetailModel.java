package zhuazhu.readhub.mvp.hotdetail.model;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.net.ReadService;

/**
 * @author zhuazhu
 **/
public class HotDetailModel implements HotDetailContract.Model {
    private final ReadService mReadService;

    @Inject
    public HotDetailModel(ReadService readService) {
        mReadService = readService;
    }

    @Override
    public Observable<HotNews> queryDetail(String topicId) {
        return mReadService
                .queryHotNewsDetail(topicId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
