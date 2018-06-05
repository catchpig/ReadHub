package zhuazhu.readhub.mvp.news.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zhuazhu.readhub.mvp.news.contract.NewsContract;
import zhuazhu.readhub.net.ReadService;

/**
 * @author zhuazhu
 **/
public class NewsModel implements NewsContract.Model {
    private final ReadService mReadService;

    @Inject
    public NewsModel(ReadService readService) {
        mReadService = readService;
    }

    @Override
    public Observable<List<News>> queryScienceNews(String lastCursor) {
        return mReadService.queryScienceNews(lastCursor).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(listAjaxResult -> listAjaxResult.getData());
    }

    @Override
    public Observable<List<News>> queryDeveloperNews(String lastCursor) {
        return mReadService.queryDevelopNews(lastCursor).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(listAjaxResult -> listAjaxResult.getData());
    }

    @Override
    public Observable<List<News>> queryChainNews(String lastCursor) {
        return mReadService.queryBlockchainNews(lastCursor).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(listAjaxResult -> listAjaxResult.getData());
    }
}
