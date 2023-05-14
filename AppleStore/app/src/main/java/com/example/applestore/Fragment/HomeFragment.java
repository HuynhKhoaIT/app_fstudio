package com.example.applestore.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.CategoryAdapter;
import com.example.applestore.Adapter.ProductAdapter;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ImageSlider imageSlider;
    private RecyclerView mRecyclerView,categoryRec;
    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);
    ProductAdapter productAdapter;
    List<Product> productList;
    List<Category> categories;
    CategoryAdapter categoryAdapter;
    private Context context;
    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Ánh xạ
        imageSlider = view.findViewById(R.id.imageSlide);
        categoryRec = view.findViewById(R.id.categoryList);
        mRecyclerView = view.findViewById(R.id.product_list);
        context = getActivity();
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        categoryRec.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        // set Data
        getCategory();
        getProduct();

        //List Slide
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bn1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bnfstudio, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bn2, ScaleTypes.FIT));
        imageSlider.startSliding(3000);
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }
    private void getCategory(){
        Call<List<Category>> call = apiService.getAllCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                if(response.isSuccessful()){
                    System.out.println(response.body().toString());
                    categories = response.body();
                    System.out.println(response.body());
                    System.out.println("Zoo");
                    System.out.println(categories.get(0).getTenDM());
                    categoryAdapter = new CategoryAdapter(getContext(),categories);
                    categoryRec.setHasFixedSize(true);
//                    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    categoryRec.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                }else{
                    Log.i("TAG","fail");
                    System.out.println("Zoo - Errors");
                }
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.i("TAG", t.toString());
                System.out.println("Zoo - Errors");
            }
        });
    }

    private void getProduct(){
        Call<List<Product>> call = apiService.getAllProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if(response.isSuccessful()){
                    System.out.println(response.body().toString());
                    productList = response.body();
                    System.out.println(response.body());
                    System.out.println("Zoo");
                    System.out.println(productList.get(0).getAnh());
                    productAdapter = new ProductAdapter(getContext(),productList);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();
                }else{
                    Log.i("TAG","fail");
                    System.out.println("Zoo - Errors");
                }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.i("TAG", t.toString());
                System.out.println("Zoo - Errors");
            }
        });
    }



}
