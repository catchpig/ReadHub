package zhuazhu.readhub.mvp.news.presenter;

import android.text.TextUtils;

import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.mvp.news.adpter.NewsAdapter;
import zhuazhu.readhub.mvp.news.contract.NewsContract;
import zhuazhu.readhub.mvp.news.model.NewsModel;
import zhuazhu.readhub.mvp.web.WebActivity;

/**
 * @author zhuazhu
 **/
public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {
    private final NewsContract.Model mModel;
    private final NewsAdapter mNewsAdapter;
    public NewsPresenter(NewsContract.View view, NewsModel newsModel, NewsAdapter newsAdapter) {
        super(view);
        mModel = newsModel;
        mNewsAdapter = newsAdapter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView.initAdapter(mNewsAdapter);
        mNewsAdapter.setOnItemClickListener((news, position) -> {
            String url = news.getMobileUrl();
            WebActivity.start(mView.getBaseActivity(),url);
        });
    }

    @Override
    public void queryScienceNews(String lastCursor) {
        mModel.queryScienceNews(lastCursor).subscribe(news -> {
            long order = news.get(news.size()-1).getPublishDate().getTime();
            mView.setLastCursor(String.valueOf(order));
            if (TextUtils.isEmpty(lastCursor)) {
                mNewsAdapter.setData(news);
            }else{
                mNewsAdapter.addData(news);
            }
        });
    }

    @Override
    public void queryDeveloperNews(String lastCursor) {
        mModel.queryDeveloperNews(lastCursor).subscribe(news -> {
            long order = news.get(news.size()-1).getPublishDate().getTime();
            mView.setLastCursor(String.valueOf(order));
            if (TextUtils.isEmpty(lastCursor)) {
                mNewsAdapter.setData(news);
            }else{
                mNewsAdapter.addData(news);
            }
        });
    }

    @Override
    public void queryChainNews(String lastCursor) {
        mModel.queryChainNews(lastCursor).subscribe(news -> {
            long order = news.get(news.size()-1).getPublishDate().getTime();
            mView.setLastCursor(String.valueOf(order));
            if (TextUtils.isEmpty(lastCursor)) {
                mNewsAdapter.setData(news);
            }else{
                mNewsAdapter.addData(news);
            }
        });
    }
}
