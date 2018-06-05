package zhuazhu.readhub.di.module;

import dagger.Module;
import dagger.Provides;
import zhuazhu.readhub.di.scope.FragmentScope;
import zhuazhu.readhub.mvp.news.adpter.NewsAdapter;
import zhuazhu.readhub.mvp.news.contract.NewsContract;
import zhuazhu.readhub.mvp.news.model.NewsModel;
import zhuazhu.readhub.mvp.news.presenter.NewsPresenter;

/**
 * @author zhuazhu
 **/
@Module
public class NewsModule extends BaseFragmentModule<NewsContract.View> {
    public NewsModule(NewsContract.View view) {
        super(view);
    }
    @FragmentScope
    @Provides
    public NewsContract.Presenter providesSciencePresenter(NewsModel scienceModel, NewsAdapter newsAdapter){
        return new NewsPresenter(mView,scienceModel,newsAdapter);
    }
    @FragmentScope
    @Provides
    public NewsAdapter providesNewsAdapter(){
        return new NewsAdapter();
    }
}
