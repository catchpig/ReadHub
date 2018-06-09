package zhuazhu.readhub.mvp.web.client;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/**
 * @author zhuazhu
 */
public class ReadHubChromeClient extends WebChromeClient {
    private onReceivedTitleListener mOnReceivedTitleListener;
    private OnRecievedProgressListener mOnRecievedProgressListener;

    public void setOnRecievedProgressListener(OnRecievedProgressListener onRecievedProgressListener) {
        mOnRecievedProgressListener = onRecievedProgressListener;
    }

    public void setOnReceivedTitleListener(onReceivedTitleListener onReceivedTitleListener) {
        mOnReceivedTitleListener = onReceivedTitleListener;
    }

    @Override
    public void onProgressChanged(WebView webView, int i) {
        if (mOnRecievedProgressListener!=null) {
            mOnRecievedProgressListener.onReceivedProgress(i);
        }
    }

    @Override
    public void onReceivedTitle(WebView webView, String s) {
        if(mOnReceivedTitleListener!=null){
            mOnReceivedTitleListener.onReceivedTitle(s);
        }
    }

    /**
     * 进度加载的监听
     */
    public interface OnRecievedProgressListener{
        void onReceivedProgress(int progress);
    }
    /**
     * 标题内容的接收监听
     */
    public interface onReceivedTitleListener{
        void onReceivedTitle(String title);
    }
}
