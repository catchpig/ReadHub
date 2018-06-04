package zhuazhu.readhub.di.component;

import dagger.Component;
import zhuazhu.readhub.di.module.AppModule;
import zhuazhu.readhub.di.module.NetModule;

/**
 * @author zhuazhu
 **/
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

}
