package zhuazhu.readhub.mvp.hotdetail;

import android.support.annotation.DrawableRes;

import io.reactivex.Observable;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;

/**
 * @author zhuazhu
 **/
public interface HotDetailContract {
    interface View extends BaseContract.View{
        /**
         * 设置标题
         * @param title
         */
        void setTitle(String title);

        /**
         * 设置文本内容
         * @param content
         */
        void setContent(String content);
        void setIndexNews(String indexNews);

        /**
         * 设置收藏的图片
         * @param flag true:设置收藏图片  false:设置未收藏图标
         */
        void updateCollectImage(boolean flag);
        void initAdapter(TimeLineAdapter timeLineAdapter, NewsPageAdapter newsPageAdapter);
    }
    interface Presenter extends BaseContract.Presenter{
        /**
         * 查询热门资讯详情
         * @param topicId
         */
        void queryDetail(String topicId);

        /**
         * 获取新闻的条数
         * @return
         */
        int getNewsPageSize();

        /**
         * 收藏热门新闻
         */
        void collectHotNew();
    }
    interface Model{
        /**
         * 查询热门资讯详情
         * @param topicId
         * @return
         */
        Observable<HotNews> queryDetail(String topicId);

        /**
         * 通过主键id查询热点信息
         * @param id
         * @return true:收藏 false:没有收藏
         */
        boolean isCollectedById(String id);

        /**
         * 保存热门资讯到数据库
         * @param hotNews
         */
        void saveHotNewsToDb(HotNews hotNews);

        /**
         * 通过id删除热门资讯
         * @param id
         */
        void deleteHotNewsFromDbById(String id);
    }
}
