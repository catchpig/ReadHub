package zhuazhu.readhub.di.component;

import dagger.Subcomponent;
import zhuazhu.readhub.di.module.HotModule;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.hot.view.HotFragment;

/**
 * @author zhuazhu
 **/
@FragmentScope
@Subcomponent(modules = HotModule.class)
public interface HotComponent {
    void inject(HotFragment hotFragment);
}
