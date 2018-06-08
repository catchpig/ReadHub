package zhuazhu.readhub.data.db.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

import zhuazhu.readhub.data.db.ReadHubDataBase;
import zhuazhu.readhub.mvp.hotdetail.model.TimeLine;
import zhuazhu.readhub.mvp.news.model.News;

/**
 * @author zhuazhu
 **/
@Table(database = ReadHubDataBase.class)
public class HotNews extends BaseModel{

    /**
     * order : 51165
     * publishDate : 2018-06-05T02:41:06.410Z
     * summary : 近日，朋友突然联系原告，称在一款游戏中弹出了ofo的推送广告，广告图片上有原告的肖像，用于推广ofo小黄车 ... 原告上网查询，在百度百科的ofo词条中，拜克洛克公司也使用了上述有原告肖像的照片，借原告外国人的特殊身份，宣传推广ofo共享单车海外战略，以突出强调其全球性，但原告对该情况并不知情 ... 在原告的国家，留学生不允许打工，且印有留学生肖像的照片如要用于广告宣传等行为，需经大使馆同意。
     * title : 因使用留学生肖像推广小黄车 ofo百度被诉侵权
     * updatedAt : 2018-06-05T02:41:07.299Z
     */
    @PrimaryKey
    private String id;
    private long order;
    private List<News> newsArray;
    private Date publishDate;
    @Column
    private String summary;
    @Column
    private String title;
    @Column
    private Date updatedAt;
    private TimeLine timeline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public List<News> getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(List<News> newsArray) {
        this.newsArray = newsArray;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TimeLine getTimeline() {
        return timeline;
    }

    public void setTimeline(TimeLine timeline) {
        this.timeline = timeline;
    }
}
