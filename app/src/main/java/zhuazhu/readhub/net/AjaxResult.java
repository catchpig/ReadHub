package zhuazhu.readhub.net;

/**
 * @author zhuazhu
 **/
public class AjaxResult<T> {
    private T data;
    private int pageSize;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
