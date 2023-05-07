package com.example.applestore.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applestore.model.Blog;
import com.example.applestore.Adapter.BlogAdapter;
import com.example.applestore.R;

import java.util.ArrayList;
import java.util.List;
public class BlogFragment extends Fragment {
    private Context context;
    private RecyclerView mRecyclerView;
    BlogAdapter adapter;
    public BlogFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        mRecyclerView = view.findViewById(R.id.blog_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        List<Blog> blogList = new ArrayList<>();
        Blog blog1 = new Blog(R.drawable.blog2, "Iphone","mô tả chi tiết tại đây nha mọi người!");
        Blog blog2 = new Blog(R.drawable.blog3, "Iphone 14","mô tả chi tiết tại đây nha mọi người!");
        Blog blog3 = new Blog(R.drawable.mac, "Macbook","mô tả chi tiết tại đây nha mọi người!");

        blogList.add(blog1);
        blogList.add(blog2);
        blogList.add(blog3);
//        BlogAdapter adapter = new BlogAdapter(context, blogList);
        adapter = new BlogAdapter(getActivity(), blogList);
        mRecyclerView.setAdapter(adapter);
        return view;
    }
}
