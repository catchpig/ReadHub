package zhuazhu.readhub.mvp.hotdetail.adapter;

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
import zhuazhu.readhub.mvp.hotdetail.model.HotTimeLine;

/**
 * @author zhuazhu
 **/
public class TimeLineAdapter extends RecyclerAdapter<HotTimeLine, TimeLineAdapter.ViewHolder> {
    @Override
    protected void bindViewHolder(ViewHolder holder, HotTimeLine hotTimeLine, int position) {
        holder.mTime.setText(TimeUtils.date2String(hotTimeLine.getCreatedAt(),new SimpleDateFormat("yyyy/MM/dd")));
        holder.mContent.setText(hotTimeLine.getTitle());
        if(mData.size()-1==position){
            holder.mLine.setVisibility(View.GONE);
        }else{
            holder.mLine.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_line, parent, false);
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.content)
        TextView mContent;
        @BindView(R.id.line)
        View mLine;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
