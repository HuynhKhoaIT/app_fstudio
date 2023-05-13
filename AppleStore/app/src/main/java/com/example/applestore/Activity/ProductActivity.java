package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.CategoryAdapter;
import com.example.applestore.Adapter.ProductAdapter;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    Context context = this;
    List<Product> productList;

    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);
    public static final String KEY_PRODUCT_ID_TO_PRODUCT_DETAIL = "KEY_PRODUCT_ID_TO_PRODUCT_DETAIL";
    //view
    int id;
    RecyclerView recProduct;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getData();
        recProduct = findViewById(R.id.product_list);
        recProduct.setLayoutManager(new GridLayoutManager(context, 2));
        getProducts();
    }
    private void getData() {
        Intent intent = getIntent();
        id = 1 + getIntent().getIntExtra(CategoryAdapter.KEY_CATEGORYID_TO_PRODUCT, 0);
    }
    private void getProducts() {
        Call<List<Product>> call = apiService.getSanPhamByDanhMuc(id);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if (response.isSuccessful()) {
                    productList = response.body();
                    productAdapter = new ProductAdapter(context, productList);
                    recProduct.setHasFixedSize(true);
                    recProduct.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();
                } else {
                    Log.i("TAG", "fail");
                    System.out.println("Zoo - Errors");
                }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.i("fail ", t.getMessage());
            }
        });
    }
}

