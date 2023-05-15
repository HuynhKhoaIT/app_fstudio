package com.example.applestore.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.CartAdapter;
import com.example.applestore.Adapter.CheckoutAdapter;
import com.example.applestore.Fragment.OrderFragment;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.SharedPreferences.SharedPrefManager;
import com.example.applestore.Utils.CurrencyFormatter;
import com.example.applestore.model.Cart;
import com.example.applestore.model.CartDetail;
import com.example.applestore.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutActivity extends AppCompatActivity {
    RecyclerView rv_product_list;
    TextView tv_total_price;
    EditText et_customer_name;
    EditText et_customer_phone;
    EditText et_customer_address;
    Button btn_checkout;

    ArrayList<CartDetail> listCartDetail;

    CartAdapter cartAdapter;
    CheckoutAdapter checkoutAdapter;

    private Context context;

    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);

        context = this;
        // anh xa
        tv_total_price = findViewById(R.id.tv_total_price);
        et_customer_name = findViewById(R.id.et_customer_name);
        et_customer_phone = findViewById(R.id.et_customer_phone);
        et_customer_address = findViewById(R.id.et_customer_address);
        btn_checkout = findViewById(R.id.btn_checkout);
        rv_product_list =  findViewById(R.id.rv_product_list);
        rv_product_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        //hiện thông tin
        User user = SharedPrefManager.getInstance(this).getUser();
        et_customer_name.setText(user.getTenKH());
        et_customer_phone.setText(user.getPhone());
        et_customer_address.setText(user.getDiaChi());

        int idUser = SharedPrefManager.getInstance(this).getUser().getMaKH();
        getCartDetail(idUser);

        // tạo đơn hàng
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderFragment.class);
                intent.putExtra("userName", et_customer_name.getText());
                intent.putExtra("userPhone", et_customer_phone.getText());
                intent.putExtra("userAddress",et_customer_address.getText());
                intent.putExtra("totalPrice",tv_total_price.getText());
                context.startActivity(intent);
            }
        });
    }
    private void getCartDetail(int idUser){
        Call<Cart> call = apiService.getGioHangBymaKH(idUser);
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(response.isSuccessful()){
                    Cart cart = response.body();
                    listCartDetail = cart.getChiTietGioHangs();
                    System.out.println(listCartDetail.size());
                    checkoutAdapter = new CheckoutAdapter(context,listCartDetail);
                    rv_product_list.setHasFixedSize(true);
                    rv_product_list.setAdapter(checkoutAdapter);
                    tv_total_price.setText( CurrencyFormatter.formatCurrency(tongTienGioHang(listCartDetail)));
                    checkoutAdapter.notifyDataSetChanged();
                }else{
                    Log.i("TAG","fail");
                }
            }
            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Log.i("TAG", t.toString());
            }
        });
    }
    public int tongTienGioHang(ArrayList<CartDetail> listCartDetail) {
        int total = 0;

        for (CartDetail cartDetail : listCartDetail) {
            int quantity = cartDetail.getSoLuong();
            int price = cartDetail.getSanPham3().getGiaBanThuong();
            total += quantity * price;
        }
        return total;
    }


}
