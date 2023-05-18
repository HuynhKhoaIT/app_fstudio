package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.DetailOrderAdapter;
import com.example.applestore.Adapter.OrderAdapter;
import com.example.applestore.Adapter.ReviewAdapter;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.SharedPreferences.SharedPrefManager;
import com.example.applestore.Utils.CurrencyFormatter;
import com.example.applestore.model.Order;
import com.example.applestore.model.OrderDetail;
import com.example.applestore.model.Product;
import com.example.applestore.model.Review;
import com.example.applestore.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewActivity extends AppCompatActivity {
    RecyclerView rcItemOrder;
    Button btnRating;
    Context context = this;
    int idOrder;
    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);

    ArrayList<OrderDetail> listOrderDetail;

    ReviewAdapter reviewAdapter;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        // anh xa
        rcItemOrder = findViewById(R.id.rcItemOrder);
        btnRating = findViewById(R.id.btnRating);
        getData();
        getOrder(idOrder);

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xây dựng 1 list các review
                //1. thông tin gồm có sản phẩm
                //2. thông tin khách hàng
                //3. thông tin về số sao review
                //4. thông tin về review chữ
                // tạo các đánh giá
                ArrayList<Review> listReview = new ArrayList<>();
            }
        });

    }
    private void getData() {
        Intent intent = getIntent();
        idOrder = getIntent().getIntExtra(OrderAdapter.KEY_ORDER_TO_PRODUCT, 0);
        System.out.println("Mã đơn hàng " + idOrder);

        user = SharedPrefManager.getInstance(context).getUser();
    }

    private void getOrder(int id) {
        Call<Order> call = apiService.getOrderbyID(id);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    Order order = response.body();
                    System.out.println("Chi tiết đơn hàng: "+order.getListChiTietDonHang().size());
                    listOrderDetail = order.getListChiTietDonHang();
                    rcItemOrder.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    reviewAdapter = new ReviewAdapter(context, listOrderDetail);
                    rcItemOrder.setHasFixedSize(true);
                    rcItemOrder.setAdapter(reviewAdapter);
                    reviewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {

            }
        });
    }
}