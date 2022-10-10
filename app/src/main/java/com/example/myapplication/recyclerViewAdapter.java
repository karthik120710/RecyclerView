package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.viewHolder> {
    List<String > mCourses;
    LayoutInflater mLayoutInflater;
    ItemClickInterface mItemClickInterface;
    recyclerViewAdapter(Context context, List<String> data,ItemClickInterface itemClickInterface){
        this.mLayoutInflater=LayoutInflater.from(context);
        this.mCourses=data;
        this.mItemClickInterface=itemClickInterface;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.recyclerview_row,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String courses=mCourses.get(position);
        holder.myText.setText(courses);

    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }
    public String getItem(int position){
        return mCourses.get(position);
    }
    public class viewHolder  extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        TextView myText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            myText=itemView.findViewById(R.id.mText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickInterface!=null) {
                mItemClickInterface.OnItemClick(v, getAdapterPosition());
            }
        }
    }
    public interface ItemClickInterface {
        void OnItemClick(View view,int position);
    }
}
