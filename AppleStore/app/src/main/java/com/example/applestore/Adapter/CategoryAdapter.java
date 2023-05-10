package com.example.applestore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applestore.R;
import com.example.applestore.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewholder> {

    List<Category> array;

    public CategoryAdapter(List<Category> array) {
        this.array = array;
    }


    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewholder holder, int position) {
        Category category = array.get(position);
        holder.category_image.setImageResource(category.getImgCategory());
        holder.category_name.setText(category.getNameCategory());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        public ImageView category_image;
        public TextView category_name;
//        public CardView category_card;


        public MyViewholder(View itemView) {
            super(itemView);
            category_image = itemView.findViewById(R.id.category_image);
            category_name = itemView.findViewById(R.id.category_name);
//            category_card = itemView.findViewById(R.id.category_card);
        }
    }

}
