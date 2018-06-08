package zhuazhu.readhub.data.db;

import com.raizlabs.android.dbflow.annotation.Database;

import static zhuazhu.readhub.data.db.ReadHubDataBase.NAME;
import static zhuazhu.readhub.data.db.ReadHubDataBase.VERSION;

/**
 * @author zhuazhu
 **/
@Database(version = VERSION,name = NAME)
public class ReadHubDataBase {
    public static final String NAME = "readhubdatabase";
    public static final int VERSION = 1;
}
