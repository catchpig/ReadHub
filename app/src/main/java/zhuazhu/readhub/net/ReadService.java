package zhuazhu.readhub.net;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author zhuazhu
 **/
public interface ReadService {
    String BASE_URL = "https://api.readhub.me/";
//    /**
//     * 热门话题
//     *
//     * @param lastCursor
//     * @param pageSize
//     * @return
//     */
//    @GET("topic")
//    Observable<TopicResp> apiTopic(
//            @Query("lastCursor") String lastCursor,
//            @Query("pageSize") int pageSize
//    );
//
//    /**
//     * topic detail
//     * @param topicId
//     * @return
//     */
//    @GET("topic/{topicId}")
//    Observable<TopicMo> apiTopicDetail(
//            @Path("topicId") String topicId);
//
//    /**
//     * 科技动态
//     *
//     * @param lastCursor
//     * @param pageSize
//     * @return
//     */
//    @GET("news")
//    Observable<NewsResp> apiTeachNews(
//            @Query("lastCursor") String lastCursor,
//            @Query("pageSize") int pageSize
//    );
//
//
//    /**
//     * 开发者资讯
//     *
//     * @param lastCursor
//     * @param pageSize
//     * @return
//     */
//    @GET("technews")
//    Observable<NewsResp> apiDevelopNews(
//            @Query("lastCursor") String lastCursor,
//            @Query("pageSize") int pageSize
//    );
//
//
//    /**
//     * 区块链资讯
//     *
//     * @param lastCursor
//     * @param pageSize
//     * @return
//     */
//    @GET("blockchain")
//    Observable<NewsResp> apiBlockchainNews(
//            @Query("lastCursor") String lastCursor,
//            @Query("pageSize") int pageSize
//    );
}
