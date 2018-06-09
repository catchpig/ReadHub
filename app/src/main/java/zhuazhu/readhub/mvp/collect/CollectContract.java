package zhuazhu.readhub.mvp.collect;

import java.util.List;

import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;

/**
 * @author zhuazhu
 */
public interface CollectContract {
    interface View extends BaseContract.View{
        /**
         * 初始化适配器
         * @param hotAdapter
         */
        void initAdapter(HotAdapter hotAdapter);

        /**
         * 结束刷新
         */
        void finishRefresh();
    }
    interface Presenter extends BaseContract.Presenter{
        /**
         * 从数据库获取收藏的热门资讯
         */
        void queryHotNewsFromDb();
    }
    interface Model{
        /**
         * 从数据库获取收藏的热门资讯
         * @return
         */
        List<HotNews> queryHotNewsFromDb();
    }
}
