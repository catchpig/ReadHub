package zhuazhu.readhub.mvp.base;

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
    }
    interface Presenter{
        void onCreate();

        void onResume();

        void onPause();

        void onStop();

        void onDestroy();
    }

}
