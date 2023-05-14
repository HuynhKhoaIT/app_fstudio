package com.example.applestore.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.applestore.APIService.APIService;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProductActivity extends AppCompatActivity {
    TextView detailName,detailPrice, detailDes;
    ImageView detailImage;
    Button btnAddProduct;
    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        btnAddProduct = findViewById(R.id.add_product);
        detailName = findViewById(R.id.name_product);
        detailPrice = findViewById(R.id.price_product);
        detailDes = findViewById(R.id.des_product);
        detailImage = findViewById(R.id.img_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailName.setText(bundle.getString("Title"));
            detailPrice.setText(bundle.getString("Price"));
            detailDes.setText(bundle.getString("Desc"));
            Glide.with(context).load(bundle.getString("Image")).into(detailImage);
        }

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Test post
                createCaterogy();
            }
        });
    }
    private void createCaterogy(){
        Category category = new Category("Test","Test");
        Call<Category> call = apiService.createCategory(category);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
            }
        });
    }
//    Bắt sự kiện khi bấm vào nút mũi tên quay lại
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}