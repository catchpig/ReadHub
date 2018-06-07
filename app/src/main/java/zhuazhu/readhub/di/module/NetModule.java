package zhuazhu.readhub.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zhuazhu.readhub.BuildConfig;
import zhuazhu.readhub.app.Config;
import zhuazhu.readhub.data.cash.ReadHubCacheProviders;
import zhuazhu.readhub.data.net.ReadService;
import zhuazhu.readhub.log.Logger;

/**
 * @author zhuazhu
 **/
@Module
public class NetModule {
    private static final String TAG = "NetModule";
    @Singleton
    @Provides
    public ReadHubCacheProviders providesReadHubCacheProviders(Application application,Gson gson){
        return new RxCache.Builder()
                .persistence(application.getFilesDir(),new GsonSpeaker(gson))
                .using(ReadHubCacheProviders.class);
    }
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(Config.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Config.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Config.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    @Singleton
    @Provides
    public HttpLoggingInterceptor providesHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Logger.i(TAG,message));
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG? HttpLoggingInterceptor.Level.BODY: HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }
    @Singleton
    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient,Gson gson){
        return new Retrofit.Builder().baseUrl(ReadService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }
    @Singleton
    @Provides
    public Gson providesGson(){
        return new GsonBuilder().setDateFormat(Config.DATE_FORMAT).create();
    }
    @Singleton
    @Provides
    public ReadService providesReadService(Retrofit retrofit){
        return retrofit.create(ReadService.class);
    }
}
