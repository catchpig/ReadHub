package zhuazhu.readhub.mvp.hot.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zhuazhu.readhub.mvp.hot.HotContract;
import zhuazhu.readhub.net.AjaxResult;
import zhuazhu.readhub.net.ReadService;

/**
 * @author zhuazhu
 **/
public class HotModel implements HotContract.Model {
    private final ReadService mReadService;

    @Inject
    public HotModel(ReadService readService) {
        mReadService = readService;
    }

    @Override
    public Observable<AjaxResult<List<HotNews>>> queryHot(String lastCursor) {
        return mReadService.queryHotNews(lastCursor).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
