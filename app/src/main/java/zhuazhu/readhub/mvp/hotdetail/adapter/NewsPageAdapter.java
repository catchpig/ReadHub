package zhuazhu.readhub.mvp.hotdetail.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.adapter.RecyclerAdapter;
import zhuazhu.readhub.mvp.news.model.News;

/**
 * @author zhuazhu
 **/
public class NewsPageAdapter extends PagerAdapter {
    private List<News> mData = new ArrayList<>();
    private RecyclerAdapter.OnItemClickListener<News> mOnItemClickListener;

    public void setOnItemClickListener(RecyclerAdapter.OnItemClickListener<News> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<News> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = (View) object;
        container.removeView(v);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.item_hot_news,container,false);
        ViewHolder holder = new ViewHolder(v);
        News news = mData.get(position);
        holder.mTitle.setText(news.getTitle());
        holder.mTime.setText(TimeUtils.date2String(news.getPublishDate(),new SimpleDateFormat("MM-dd HH:mm")));
        String author = news.getAuthorName();
        holder.mAuthor.setText(String.format("%s/%s",news.getSiteName(), TextUtils.isEmpty(author)?"":author));
        container.addView(v);
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(v1 -> mOnItemClickListener.onItemClick(news,position));
        }
        return v;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.author)
        TextView mAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
