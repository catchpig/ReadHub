package zhuazhu.readhub.di.component;

import dagger.Subcomponent;
import zhuazhu.readhub.di.module.CollectModule;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.collect.view.CollectFragment;

/**
 * @author zhuazhu
 */
@FragmentScope
@Subcomponent(modules = CollectModule.class)
public interface CollectComponent {
    void inject(CollectFragment collectFragment);
}
