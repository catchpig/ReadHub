package zhuazhu.readhub.mvp.hot.model;

import java.util.Date;

/**
 * @author zhuazhu
 **/
public class HotNews {

    /**
     * order : 51165
     * publishDate : 2018-06-05T02:41:06.410Z
     * summary : 近日，朋友突然联系原告，称在一款游戏中弹出了ofo的推送广告，广告图片上有原告的肖像，用于推广ofo小黄车 ... 原告上网查询，在百度百科的ofo词条中，拜克洛克公司也使用了上述有原告肖像的照片，借原告外国人的特殊身份，宣传推广ofo共享单车海外战略，以突出强调其全球性，但原告对该情况并不知情 ... 在原告的国家，留学生不允许打工，且印有留学生肖像的照片如要用于广告宣传等行为，需经大使馆同意。
     * title : 因使用留学生肖像推广小黄车 ofo百度被诉侵权
     * updatedAt : 2018-06-05T02:41:07.299Z
     */
    private String id;
    private long order;
    private Date publishDate;
    private String summary;
    private String title;
    private Date updatedAt;

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
}
