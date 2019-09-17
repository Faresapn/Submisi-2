package com.example.sub2.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sub2.R;
import com.example.sub2.fragment.film_fragment;

import java.util.ArrayList;
public class Adapter extends RecyclerView.Adapter<Adapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Items> mList;
    View v;
    private OnItemClickListener mListener;


    public Adapter(Context context, ArrayList<Items> mList) {
        this.context = context;
        this.mList = mList;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;



        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_show);
            mTextView1 = itemView.findViewById(R.id.tittle_show);
            mTextView2 = itemView.findViewById(R.id.releas_show);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }



    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(context).inflate(R.layout.main_items,viewGroup,false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Items currentItem = mList.get(position);

        holder.mImageView.setImageResource(currentItem.getImage_film());
        holder.mTextView1.setText(currentItem.getTitle_film());
        holder.mTextView2.setText(currentItem.getInfo_film());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
