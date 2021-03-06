package com.dace.textreader.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dace.textreader.R;
import com.dace.textreader.bean.ReadTabAlbumDetailBean;
import com.dace.textreader.util.GlideUtils;

import java.util.List;

public class ReaderTabAlbumDetailListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ReadTabAlbumDetailBean.DataBean.BookBean.ArticleListBean> itemData;
    private Context context;
    public ReaderTabAlbumDetailListAdapter(Context context ,List<ReadTabAlbumDetailBean.DataBean.BookBean.ArticleListBean> itemData){
        this.context = context;
        this.itemData = itemData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_reader_rocommend_tab_album, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ItemHolder)viewHolder).tv_title.setText(itemData.get(i).getTitle());
        ((ItemHolder)viewHolder).tv_sub.setText(itemData.get(i).getSubContent());

//                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ((ItemHolder) viewHolder).iv_img.getLayoutParams();
//                params.width = DensityUtil.getScreenWidth(context) - DensityUtil.dip2px(context, 25f);
//                ((ItemHolder) viewHolder).iv_img.setLayoutParams(params);
        GlideUtils.loadHomeImage(context, itemData.get(i).getImage(),
                ((ItemHolder) viewHolder).iv_img);
    }

    @Override
    public int getItemCount() {
        return itemData == null ? 0 : itemData.size();
    }

    public void refreshData(List<ReadTabAlbumDetailBean.DataBean.BookBean.ArticleListBean> itemData) {
//        this.itemData.clear();
//        this.itemData.addAll(itemata);
        this.itemData = itemData;
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_title,tv_sub;

        ItemHolder(@NonNull View itemView) {
            super(itemView);
            iv_img =  itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_sub = itemView.findViewById(R.id.tv_sub);
        }
    }
}
