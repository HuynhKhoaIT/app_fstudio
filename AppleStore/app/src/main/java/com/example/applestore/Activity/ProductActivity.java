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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getData();
        recProduct = findViewById(R.id.product_list);
    }

    private void getData() {
        Intent intent = getIntent();
        id = getIntent().getIntExtra(CategoryAdapter.KEY_CATEGORYID_TO_PRODUCT, 0);
    }
    private void getProducts(){

        Call<List<Product>> call = apiService.getProduct(id);
        call.enqueue(new Callback<List<Product>>() {
                         @Override
                         public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                             if (response.isSuccessful()) {
                                 productList = response.body();

                                 ProductAdapter productAdapter = new ProductAdapter(context, R.layout.row_item_product, productList);

                                 gvProduct.setAdapter(productAdapter);

                                 gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                     @Override
                                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                         Intent intent = new Intent(context, ProductDetailActivity.class);
                                         intent.putExtra(KEY_PRODUCT_ID_TO_PRODUCT_DETAIL, position);
                                         startActivity(intent);
                                     }
                                 });

                             }
                             else {
                                 Toast.makeText(ProductActivity.this, "fail", Toast.LENGTH_LONG).show();
                             }
}

//
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Log.i("fail ", t.getMessage());
//            }
//        });
//}
//    private void getProducts(){
//        Call<List<Product>> call = apiService.getAllProduct();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//
//                if(response.isSuccessful()){
//                    System.out.println(response.body().toString());
//                    productList = response.body();
//                    System.out.println(response.body());
//                    System.out.println("Zoo");
//                    System.out.println(productList.get(0).getAnh());
//                    productAdapter = new ProductAdapter(getContext(),productList);
//                    mRecyclerView.setHasFixedSize(true);
//                    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//                    mRecyclerView.setAdapter(productAdapter);
//                    productAdapter.notifyDataSetChanged();
//
//                }else{
//                    Log.i("TAG","fail");
//                    System.out.println("Zoo - Errors");
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Log.i("TAG", t.toString());
//                System.out.println("Zoo - Errors");
//            }
//        });
//    }
