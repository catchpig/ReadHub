package zhuazhu.readhub.di.component;

import dagger.Subcomponent;
import zhuazhu.readhub.di.module.NewsModule;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.news.view.ChainFragment;
import zhuazhu.readhub.mvp.news.view.DeveloperFragment;
import zhuazhu.readhub.mvp.news.view.ScienceFragment;

/**
 * @author zhuazhu
 **/
@FragmentScope
@Subcomponent(modules = NewsModule.class)
public interface NewsComponent {
    void inject(ScienceFragment scienceFragment);
    void inject(DeveloperFragment developerFragment);
    void inject(ChainFragment chainFragment);
}
