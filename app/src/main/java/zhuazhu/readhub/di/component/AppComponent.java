package zhuazhu.readhub.di.component;

import javax.inject.Singleton;

import dagger.Component;
import zhuazhu.readhub.di.module.AppModule;
import zhuazhu.readhub.di.module.CollectModule;
import zhuazhu.readhub.di.module.HotDetailModule;
import zhuazhu.readhub.di.module.HotModule;
import zhuazhu.readhub.di.module.NetModule;
import zhuazhu.readhub.di.module.NewsModule;

/**
 * @author zhuazhu
 **/
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    HotComponent hotComponent(HotModule hotModule);

    NewsComponent newsComponent(NewsModule newsModule);

    CollectComponent collectComponent(CollectModule collectModule);

    HotDetailComponent hotDetailComponent(HotDetailModule hotDetailModule);
}
