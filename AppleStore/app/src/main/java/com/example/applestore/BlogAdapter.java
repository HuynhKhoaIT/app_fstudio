package com.example.applestore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {
    private Context context;
    private List<Blog> blogList;

    public BlogAdapter(Context applicationContext, List<Blog> blogList) {
        this.context = applicationContext;
        this.blogList = blogList;
    }


    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blog, parent, false);
        return new BlogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        Blog blog = blogList.get(position);
        holder.blogImage.setImageResource(blog.getImage());
        holder.blogName.setText(blog.getName());
        System.out.println("11111111111111111111");
        System.out.println(blog.getDesc());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", blogList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", blogList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("Desc", blogList.get(holder.getAdapterPosition()).getDesc());
                System.out.println(intent);
                System.out.println(context);
                context.startActivity(intent);
            }
        });
    }
    public class BlogViewHolder extends RecyclerView.ViewHolder {
        public ImageView blogImage;
        public TextView blogName,blogDesc;
        public CardView recCard;
        public BlogViewHolder(View itemView) {
            super(itemView);
            blogImage = itemView.findViewById(R.id.blog_image);
            blogName = itemView.findViewById(R.id.blog_name);
            blogDesc = itemView.findViewById(R.id.blog_desc);
            recCard = itemView.findViewById(R.id.recCard);
        }
    }


    @Override
    public int getItemCount() {
        return blogList.size();
    }
}

