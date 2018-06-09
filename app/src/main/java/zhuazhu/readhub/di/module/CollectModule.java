package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.collect.CollectContract;
import zhuazhu.readhub.mvp.collect.model.CollectModel;
import zhuazhu.readhub.mvp.collect.presenter.CollectPresenter;
import zhuazhu.readhub.mvp.hot.adapter.HotAdapter;

/**
 * @author zhuazhu
 */
@Module
public class CollectModule extends BaseFragmentModule<CollectContract.View> {
    public CollectModule(CollectContract.View view) {
        super(view);
    }
    @FragmentScope
    @Provides
    public HotAdapter providesHotAdapter(){
        return new HotAdapter();
    }
    @FragmentScope
    @Provides
    public CollectContract.Presenter providesCollectPresenter(CollectModel collectModel,HotAdapter hotAdapter){
        return new CollectPresenter(mView,collectModel,hotAdapter);
    }
}
