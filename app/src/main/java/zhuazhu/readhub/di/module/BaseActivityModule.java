package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.ActivityScope;
import zhuazhu.readhub.mvp.base.BaseContract;

/**
 * @author zhuazhu
 **/
@Module
public abstract class BaseActivityModule<V extends BaseContract.View> {
    protected final V mView;

    public BaseActivityModule(V view) {
        mView = view;
    }
    @ActivityScope
    @Provides
    public V provideView() {
        return mView;
    }
}
