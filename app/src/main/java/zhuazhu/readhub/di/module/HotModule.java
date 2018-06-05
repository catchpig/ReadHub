package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.hot.HotContract;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;
import zhuazhu.readhub.mvp.hot.model.HotModel;
import zhuazhu.readhub.mvp.hot.presenter.HotPresenter;

/**
 * @author zhuazhu
 **/
@Module
public class HotModule extends BaseFragmentModule<HotContract.View> {
    public HotModule(HotContract.View view) {
        super(view);
    }
    @FragmentScope
    @Provides
    public HotAdapter providesHotAdapter(){
        return new HotAdapter();
    }
    @FragmentScope
    @Provides
    public HotContract.Presenter providesHotPresenter(HotModel hotModel,HotAdapter hotAdapter){
        return new HotPresenter(mView,hotModel,hotAdapter);
    }
}
