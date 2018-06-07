package zhuazhu.readhub.data.cash;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.LifeCache;
import io.rx_cache2.ProviderKey;
import retrofit2.http.GET;
import zhuazhu.readhub.data.net.AjaxResult;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.news.model.News;

/**
 * RxCache缓存
 * @author zhuazhu
 **/
public interface ReadHubCacheProviders {
    /**
     * 热门资讯详情
     *
     * @param observable
     * @param dynamicKey
     * @return
     */
    @ProviderKey("queryHotNews")
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<List<HotNews>> queryHotNews(Observable<List<HotNews>> observable, DynamicKey dynamicKey);

    /**
     * 热门资讯详情
     *
     * @param observable
     * @param dynamicKey
     * @return
     */
    @ProviderKey("queryHotNewsDetail")
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<HotNews> queryHotNewsDetail(Observable<HotNews> observable, DynamicKey dynamicKey);

    /**
     * 科技动态
     *
     * @param observable
     * @param dynamicKey
     * @return
     */
    @ProviderKey("queryScienceNews")
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<List<News>> queryScienceNews(Observable<List<News>> observable, DynamicKey dynamicKey);

    /**
     * 开发者资讯
     *
     * @param observable
     * @param dynamicKey
     * @return
     */
    @ProviderKey("queryDevelopNews")
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<List<News>> queryDevelopNews(Observable<List<News>> observable, DynamicKey dynamicKey);

    /**
     * 区块链资讯
     *
     * @param observable
     * @param dynamicKey
     * @return
     */
    @ProviderKey("queryBlockchainNews")
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<List<News>> queryBlockchainNews(Observable<List<News>> observable, DynamicKey dynamicKey);
}
