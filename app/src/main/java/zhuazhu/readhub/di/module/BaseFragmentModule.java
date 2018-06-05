package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.base.BaseContract;

/**
 * @author zhuazhu
 **/
@Module
public abstract class BaseFragmentModule<V extends BaseContract.View> {
    protected final V mView;

    public BaseFragmentModule(V view) {
        mView = view;
    }
    @FragmentScope
    @Provides
    public V providesView(){
        return mView;
    }
}
