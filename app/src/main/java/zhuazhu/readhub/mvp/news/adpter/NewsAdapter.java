package zhuazhu.readhub.mvp.news.adpter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import zhuazhu.readhub.mvp.news.model.News;

/**
 * @author zhuazhu
 **/
public class NewsAdapter extends RecyclerAdapter<News,NewsAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    protected void bindViewHolder(ViewHolder holder, News news, int position) {
        holder.mTitle.setText(news.getTitle());
        holder.mTime.setText(TimeUtils.date2String(news.getPublishDate(),new SimpleDateFormat("MM-dd HH:mm")));
        holder.mContent.setText(news.getSummary());
        String author = news.getAuthorName();
        holder.mAuthor.setText(String.format("%s/%s",news.getSiteName(),TextUtils.isEmpty(author)?"":author));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.content)
        TextView mContent;
        @BindView(R.id.author)
        TextView mAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
