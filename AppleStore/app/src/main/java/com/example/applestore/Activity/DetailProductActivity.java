package com.example.applestore.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.applestore.APIService.APIService;
import com.example.applestore.Fragment.CartFragment;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.SharedPreferences.SharedPrefManager;
import com.example.applestore.model.CartDetail;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProductActivity extends AppCompatActivity {
    TextView detailName,detailPrice, detailDes,amount;
    ImageView detailImage;
    Button btnAddProduct,btn_minus,btn_plus;
    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        // anh xa
        btnAddProduct = findViewById(R.id.add_product);
        detailName = findViewById(R.id.name_product);
        detailPrice = findViewById(R.id.price_product);
        detailDes = findViewById(R.id.des_product);
        detailImage = findViewById(R.id.img_product);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        amount = findViewById(R.id.amount);

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
                // lấy số lượng
                int amountProduct;
                try {
                    String amountString = amount.getText().toString();
                    amountProduct = Integer.parseInt(amountString);
                } catch (NumberFormatException e) {
                    amountProduct = 0;
                }
                // lấy id sản phấm
                int idSP = bundle.getInt("maSP");
                // lấy id khác hàng
                int idKH = SharedPrefManager.getInstance(context).getUser().getMaKH();

                addProductToCart(amountProduct,idSP,idKH);
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void addProductToCart(int amountProduct,int idSP,int idKH){
        //tạo ra 1 CartDetail
        CartDetail cartDetail = new CartDetail(idSP,amountProduct);

        Call<CartDetail> call = apiService.addProductToCart(cartDetail,idKH);
        call.enqueue(new Callback<CartDetail>() {
            @Override
            public void onResponse(Call<CartDetail> call, Response<CartDetail> response) {
                if(response.isSuccessful())
                {
                    System.out.println(response.body());
                    Toast.makeText(context,"Thêm thành công",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(context,"Thêm sản phẩm thất bại",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<CartDetail> call, Throwable t) {
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