package zhuazhu.readhub.di.module;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.OkHttpClient;
import zhuazhu.readhub.app.Config;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;

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
