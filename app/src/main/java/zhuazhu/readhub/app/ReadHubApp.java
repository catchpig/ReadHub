package zhuazhu.readhub.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.tencent.bugly.crashreport.CrashReport;

import zhuazhu.readhub.BuildConfig;
import zhuazhu.readhub.di.component.AppComponent;
import zhuazhu.readhub.di.component.DaggerAppComponent;
import zhuazhu.readhub.di.module.AppModule;
import zhuazhu.readhub.di.module.NetModule;

/**
 * @author zhuazhu
 **/
public class ReadHubApp extends Application {
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setEnableHeaderTranslationContent(false);
                return new MaterialHeader(context);
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
                return new FalsifyFooter(context);
            }
        });
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Rigger.enableDebugLogging(true);
        initCash();
    }
    private void initCash(){
        CrashReport.initCrashReport(getApplicationContext(),Config.BUGLY_APP_ID, BuildConfig.DEBUG);
    }

    private static AppComponent mAppComponent;
    public static AppComponent getAppComponent(){
        if(mAppComponent==null){
            mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(Utils.getApp())).netModule(new NetModule()).build();
        }
        return mAppComponent;
    }
}
