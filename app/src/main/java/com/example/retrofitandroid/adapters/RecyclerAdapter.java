package com.example.retrofitandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.retrofitandroid.R;
import com.example.retrofitandroid.model.Album;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> mAlbumList;

    public RecyclerAdapter(Context mContext, List<Album> mAlbumList) {
        this.mContext = mContext;
        this.mAlbumList = mAlbumList;
    }

    public void setAlbumList(List<Album> mAlbumList) {
        this.mAlbumList = mAlbumList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mImageTitle.setText(mAlbumList.get(position).getImageTitle());

        Glide.with(mContext).load(mAlbumList.get(position).getImageThumbnail())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mImage);

        holder.mImageId.setText(mAlbumList.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        if (mAlbumList != null) {
            return mAlbumList.size();
        }
        return 0;

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mImageTitle, mImageId;
        ImageView mImage;

        MyViewHolder(View itemView) {
            super(itemView);
            mImageTitle = (TextView) itemView.findViewById(R.id.title);
            mImageId = (TextView) itemView.findViewById(R.id.id);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
