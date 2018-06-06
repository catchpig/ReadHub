package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.ActivityScope;
import zhuazhu.readhub.mvp.hotdetail.HotDetailContract;
import zhuazhu.readhub.mvp.hotdetail.adapter.NewsPageAdapter;
import zhuazhu.readhub.mvp.hotdetail.adapter.TimeLineAdapter;
import zhuazhu.readhub.mvp.hotdetail.model.HotDetailModel;
import zhuazhu.readhub.mvp.hotdetail.presenter.HotDetailPresenter;

/**
 * @author zhuazhu
 **/
@Module
public class HotDetailModule extends BaseActivityModule<HotDetailContract.View> {
    public HotDetailModule(HotDetailContract.View view) {
        super(view);
    }
    @ActivityScope
    @Provides
    public NewsPageAdapter providesNewsPageAdapter(){
        return new NewsPageAdapter();
    }
    @ActivityScope
    @Provides
    public TimeLineAdapter providesTimeLineAdapter(){
        return new TimeLineAdapter();
    }
    @ActivityScope
    @Provides
    public HotDetailContract.Presenter providesHotDetailPresenter(HotDetailModel hotDetailModel,TimeLineAdapter timeLineAdapter,NewsPageAdapter newsPageAdapter){
        return new HotDetailPresenter(mView,hotDetailModel,timeLineAdapter,newsPageAdapter);
    }
}
