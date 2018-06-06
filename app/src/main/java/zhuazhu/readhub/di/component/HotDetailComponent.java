package zhuazhu.readhub.di.component;

import dagger.Subcomponent;
import zhuazhu.readhub.di.module.HotDetailModule;
import zhuazhu.readhub.di.module.HotModule;
import zhuazhu.readhub.di.scope.ActivityScope;
import zhuazhu.readhub.mvp.hotdetail.view.HotDetailActivity;

/**
 * @author zhuazhu
 **/
@ActivityScope
@Subcomponent(modules = HotDetailModule.class)
public interface HotDetailComponent {
    void inject(HotDetailActivity hotDetailActivity);
}
