package zhuazhu.readhub.mvp.hotdetail.model;

import java.util.List;

/**
 * @author zhuazhu
 **/
public class TimeLine {
    private String message;
    private List<HotTimeLine> topics;

    public List<HotTimeLine> getTopics() {
        return topics;
    }

    public void setTopics(List<HotTimeLine> topics) {
        this.topics = topics;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
