package zhuazhu.readhub.mvp.hot;


import java.util.List;

import io.reactivex.Observable;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;
import zhuazhu.readhub.mvp.hot.model.HotNews;
import zhuazhu.readhub.net.AjaxResult;

/**
 * @author zhuazhu
 **/
public interface HotContract {
    interface View extends BaseContract.View {
        /**
         * 初始化适配器
         * @param hotAdapter
         */
        void initAdapter(HotAdapter hotAdapter);

        void setLastCursor(String lastCursor);
    }

    interface Presenter extends BaseContract.Presenter {
        void queryHotNews(String lastCursor);
    }

    interface Model {
        Observable<AjaxResult<List<HotNews>>> queryHot(String lastCursor);
    }
}