package zhuazhu.readhub.di.module;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import zhuazhu.readhub.app.Config;

/**
 * @author zhuazhu
 **/
@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }
    @Singleton
    @Provides
    public Application providesApplication(){
        return mApplication;
    }
}
