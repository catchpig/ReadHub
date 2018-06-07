package zhuazhu.readhub.mvp.news.presenter;

import android.text.TextUtils;

import java.util.List;

import zhuazhu.readhub.aop.annotaion.SingleClick;
import zhuazhu.readhub.mvp.base.BasePresenter;
import zhuazhu.readhub.mvp.base.adapter.RecyclerAdapter;
import zhuazhu.readhub.mvp.news.adpter.NewsAdapter;
import zhuazhu.readhub.mvp.news.contract.NewsContract;
import zhuazhu.readhub.mvp.news.model.News;
import zhuazhu.readhub.mvp.news.model.NewsModel;
import zhuazhu.readhub.mvp.web.WebActivity;
import zhuazhu.readhub.data.net.HttpObservable;

/**
 * @author zhuazhu
 **/
public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter,RecyclerAdapter.OnItemClickListener<News> {
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
        mNewsAdapter.setOnItemClickListener(this);
    }

    @Override
    public void queryScienceNews(String lastCursor) {
        execute(mModel.queryScienceNews(lastCursor), new HttpObservable<List<News>>() {
            @Override
            public void onNext(List<News> news) {
                long order = news.get(news.size()-1).getPublishDate().getTime();
                mView.setLastCursor(String.valueOf(order));
                if (TextUtils.isEmpty(lastCursor)) {
                    mNewsAdapter.setData(news);
                }else{
                    mNewsAdapter.addData(news);
                }
            }
        });
    }

    @Override
    public void queryDeveloperNews(String lastCursor) {
        execute(mModel.queryDeveloperNews(lastCursor), new HttpObservable<List<News>>() {
            @Override
            public void onNext(List<News> news) {
                long order = news.get(news.size()-1).getPublishDate().getTime();
                mView.setLastCursor(String.valueOf(order));
                if (TextUtils.isEmpty(lastCursor)) {
                    mNewsAdapter.setData(news);
                }else{
                    mNewsAdapter.addData(news);
                }
            }
        });
    }

    @Override
    public void queryChainNews(String lastCursor) {
        execute(mModel.queryChainNews(lastCursor), new HttpObservable<List<News>>() {
            @Override
            public void onNext(List<News> news) {
                long order = news.get(news.size()-1).getPublishDate().getTime();
                mView.setLastCursor(String.valueOf(order));
                if (TextUtils.isEmpty(lastCursor)) {
                    mNewsAdapter.setData(news);
                }else{
                    mNewsAdapter.addData(news);
                }
            }
        });
    }

    @SingleClick
    @Override
    public void onItemClick(News news, int position) {
        String url = news.getMobileUrl();
        WebActivity.start(mView.getBaseActivity(),url);
    }
}
