package zhuazhu.readhub.data.db;

import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

import zhuazhu.readhub.data.db.model.HotNews;
import zhuazhu.readhub.data.db.model.HotNews_Table;

/**
 * @author zhuazhu
 */
@Migration(version = ReadHubDataBase.VERSION,database = ReadHubDataBase.class)
public class Migrations_2_HotNews extends AlterTableMigration<HotNews> {
    public Migrations_2_HotNews(Class<HotNews> table) {
        super(table);
    }

    @Override
    public void onPreMigrate() {
        addColumn(SQLiteType.INTEGER, HotNews_Table.order.getNameAlias().name());
    }
}
