package zhuazhu.readhub.mvp.hotdetail;

import io.reactivex.Observable;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;

/**
 * @author zhuazhu
 **/
public interface HotDetailContract {
    interface View extends BaseContract.View{
        void setTitle(String title);
        void setContent(String content);
        void setIndexNews(String indexNews);
        void initAdapter(TimeLineAdapter timeLineAdapter, NewsPageAdapter newsPageAdapter);
    }
    interface Presenter extends BaseContract.Presenter{
        /**
         * 查询热门资讯详情
         * @param topicId
         */
        void queryDetail(String topicId);

        int getPageSize();
    }
    interface Model{
        /**
         * 查询热门资讯详情
         * @param topicId
         * @return
         */
        Observable<HotNews> queryDetail(String topicId);
    }
}
