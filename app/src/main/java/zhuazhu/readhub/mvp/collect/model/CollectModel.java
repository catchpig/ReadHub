package zhuazhu.readhub.mvp.collect.model;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;

import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.mvp.collect.CollectContract;

/**
 * @author zhuazhu
 */
public class CollectModel implements CollectContract.Model {
    @Inject
    public CollectModel() {
    }

    @Override
    public List<HotNews> queryHotNewsFromDb() {
        return SQLite.select().from(HotNews.class).queryList();
    }
}
