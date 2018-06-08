package zhuazhu.readhub.mvp.hot.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.adapter.RecyclerAdapter;
import zhuazhu.readhub.data.db.model.HotNews;

/**
 * @author zhuazhu
 **/
public class HotAdapter extends RecyclerAdapter<HotNews,HotAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot, parent, false);
        return new ViewHolder(v);
    }

    @Override
    protected void bindViewHolder(ViewHolder holder, HotNews hotNews, int position) {
        holder.mTitle.setText(hotNews.getTitle());
        holder.mContent.setText(hotNews.getSummary());
        holder.mTime.setText(TimeUtils.date2String(hotNews.getUpdatedAt(),new SimpleDateFormat("MM-dd HH:mm")));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.content)
        TextView mContent;
        @BindView(R.id.time)
        TextView mTime;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
