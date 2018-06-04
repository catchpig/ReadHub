package zhuazhu.readhub.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import zhuazhu.readhub.di.component.AppComponent;
import zhuazhu.readhub.di.component.DaggerAppComponent;
import zhuazhu.readhub.di.module.AppModule;
import zhuazhu.readhub.di.module.NetModule;

/**
 * @author zhuazhu
 **/
public class ReadHubApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }

    private static AppComponent mAppComponent;
    public static AppComponent getAppComponent(){
        if(mAppComponent==null){
            mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(Utils.getApp())).netModule(new NetModule()).build();
        }
        return mAppComponent;
    }
}
