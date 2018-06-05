package zhuazhu.readhub.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zhuazhu.readhub.BuildConfig;
import zhuazhu.readhub.app.Config;
import zhuazhu.readhub.net.ReadService;

/**
 * @author zhuazhu
 **/
@Module
public class NetModule {
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(Config.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Config.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Config.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor).build();
    }
    @Singleton
    @Provides
    public HttpLoggingInterceptor providesHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG? HttpLoggingInterceptor.Level.BODY: HttpLoggingInterceptor.Level.NONE);
    }
    @Singleton
    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl(ReadService.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat(Config.DATE_FORMAT).create()))
                .client(okHttpClient)
                .build();
    }
    @Singleton
    @Provides
    public ReadService providesReadService(Retrofit retrofit){
        return retrofit.create(ReadService.class);
    }
}
