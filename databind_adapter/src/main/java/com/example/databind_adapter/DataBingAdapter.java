package com.example.databind_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataBingAdapter<T> extends RecyclerView.Adapter<DataBingAdapter<T>.MyViewHolder> {
    private List<T> data;
    private Context context;
    private int varariableId;
    private int layoutId;

    public DataBingAdapter(List<T> data, Context context, int varariableId, int layoutId) {
        this.data = data;
        this.context = context;
        this.varariableId = varariableId;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setContent(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding viewDataBinding;

        public MyViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }

        public void setContent(T t) {
            viewDataBinding.setVariable(varariableId, t);
            viewDataBinding.executePendingBindings();
        }
    }
}
