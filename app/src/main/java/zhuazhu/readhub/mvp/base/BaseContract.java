package zhuazhu.readhub.mvp.base;

import zhuazhu.readhub.mvp.base.activity.BaseActivity;

/**
 * @author zhuazhu
 **/
public interface BaseContract{
    interface View{
        /**
         * 弹出吐司
         * @param msg
         */
        void showToast(String msg);

        BaseActivity getBaseActivity();
    }
    interface Presenter{
        void onCreate();

        void onResume();

        void onPause();

        void onStop();

        void onDestroy();
    }

}
