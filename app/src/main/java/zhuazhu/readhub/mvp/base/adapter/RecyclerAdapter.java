package zhuazhu.readhub.mvp.base.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhuazhu
 **/
public abstract class RecyclerAdapter<M,V extends ViewHolder> extends Adapter<V> {
    protected List<M> mData = new ArrayList<>();
    private OnItemClickListener<M> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<M> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<M> data) {
        if(data!=null){
            mData = data;
        }else{
            mData.clear();
        }
        notifyDataSetChanged();
    }
    public void addData(List<M> data){
        if(data==null){
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(V holder, int position) {
        M m = mData.get(position);
        bindViewHolder(holder,m,position);
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(v -> {
                if(mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(m,position);
                }
            });
        }
    }

    /**
     *
     * @param holder
     * @param m 实体
     * @param position 下标
     */
    protected abstract void bindViewHolder(V holder,M m,int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public interface OnItemClickListener<M>{
        void onItemClick(M m,int position);
    }
}
