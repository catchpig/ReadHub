package zhuazhu.readhub.data.net;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.news.model.News;

/**
 * @author zhuazhu
 **/
public interface ReadService {
    String BASE_URL = "https://api.readhub.me/";

    /**
     * 热门话题
     *
     * @param lastCursor
     * @return
     */
    @GET("topic?pageSize=20")
    Observable<AjaxResult<List<HotNews>>> queryHotNews(@Query("lastCursor") String lastCursor);

    /**
     * 获取热门详情
     * @param topicId
     * @return
     */
    @GET("topic/{topicId}")
    Observable<HotNews> queryHotNewsDetail(@Path("topicId") String topicId);

    /**
     * 科技动态
     *
     * @param lastCursor
     * @return
     */
    @GET("news?pageSize=20")
    Observable<AjaxResult<List<News>>> queryScienceNews(@Query("lastCursor") String lastCursor);

    /**
     * 开发者资讯
     *
     * @param lastCursor
     * @return
     */
    @GET("technews?pageSize=20")
    Observable<AjaxResult<List<News>>> queryDevelopNews(@Query("lastCursor") String lastCursor);

    /**
     * 区块链资讯
     *
     * @param lastCursor
     * @return
     */
    @GET("blockchain?pageSize=20")
    Observable<AjaxResult<List<News>>> queryBlockchainNews(@Query("lastCursor") String lastCursor);
}
