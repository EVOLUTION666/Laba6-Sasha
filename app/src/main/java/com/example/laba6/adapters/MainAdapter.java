package com.example.laba6.adapters;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;


import com.example.laba6.Model;
import com.example.laba6.R;

import java.io.Serializable;
import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ExampleViewHolder> implements Serializable {
    private Context mContext;
    List<Model>models;





    public MainAdapter(Context context, List<Model>newModels) {
        mContext=context;
        models=newModels;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_card, null);
        return new ExampleViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Model currentItem =models.get(position);
        String name = currentItem.getName();
        int price=currentItem.getPrice();
        holder.nameTextView.setText(name);
        holder.priceTextView.setText(String.valueOf(price));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView priceTextView;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.mainAdapterName);
            priceTextView=itemView.findViewById(R.id.mainAdapterPrice);
        }
    }

}

