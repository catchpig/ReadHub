package zhuazhu.readhub.mvp.news.contract;

import java.util.List;

import io.reactivex.Observable;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.news.adpter.NewsAdapter;
import zhuazhu.readhub.mvp.news.model.News;

/**
 * @author zhuazhu
 **/
public interface NewsContract {
    interface View extends BaseContract.View{
        void initAdapter(NewsAdapter newsAdapter);
        void setLastCursor(String lastCursor);
    }
    interface Presenter extends BaseContract.Presenter{
        /**
         * 获取科技动态列表
         * @param lastCursor
         */
        void queryScienceNews(String lastCursor);
        /**
         * 获取开发者资讯列表
         * @param lastCursor
         */
        void queryDeveloperNews(String lastCursor);

        /**
         * 获取区块链快讯列表
         * @param lastCursor
         */
        void queryChainNews(String lastCursor);
    }
    interface Model{
        /**
         * 获取科技动态列表
         * @param lastCursor
         * @return
         */
        Observable<List<News>> queryScienceNews(String lastCursor);

        /**
         * 获取开发者资讯列表
         * @param lastCursor
         * @return
         */
        Observable<List<News>> queryDeveloperNews(String lastCursor);

        /**
         * 获取区块链快讯列表
         * @param lastCursor
         * @return
         */
        Observable<List<News>> queryChainNews(String lastCursor);
    }

}
