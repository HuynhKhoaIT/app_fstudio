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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.applestore.APIService.APIService;
import com.example.applestore.Adapter.CartAdapter;
import com.example.applestore.Adapter.CategoryAdapter;
import com.example.applestore.R;
import com.example.applestore.Retrofit.RetrofitClient;
import com.example.applestore.SharedPreferences.SharedPrefManager;
import com.example.applestore.model.Cart;
import com.example.applestore.model.CartDetail;
import com.example.applestore.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {
    private Context context;
    APIService apiService = RetrofitClient.getRetrofit().create(APIService.class);

    List<CartDetail> listCartDetail;

    TextView cart_subtotal_text;
    TextView cart_subtotal_value;
    Button cart_checkout_button;
    RecyclerView rcItemCart;
    CartAdapter cartAdapter;

    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        //Ánh xạ
        cart_subtotal_text = view.findViewById(R.id.cart_subtotal_text);
        cart_subtotal_value = view.findViewById(R.id.cart_subtotal_value);
        cart_checkout_button = view.findViewById(R.id.cart_checkout_button);
        rcItemCart = view.findViewById(R.id.rcItemCart);
        rcItemCart.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        context = getActivity();

        int idUser = SharedPrefManager.getInstance(context).getUser().getMaKH();
        System.out.println(idUser);

        getCartDetail(idUser);

        return view;
    }
    private void getCartDetail(int idUser){
        Call<Cart> call = apiService.getGioHangBymaKH(idUser);
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(response.isSuccessful()){
                    Cart cart = response.body();
                    System.out.println(response.body());
                    System.out.println(cart.getChiTietGioHangs().size());
                    listCartDetail = cart.getChiTietGioHangs();
                    System.out.println(response.body());
                    System.out.println("Zoo");
                    cartAdapter = new CartAdapter(getContext(),listCartDetail);
                    rcItemCart.setHasFixedSize(true);
                    rcItemCart.setAdapter(cartAdapter);
                    cartAdapter.notifyDataSetChanged();
                }else{
                    Log.i("TAG","fail");
                    System.out.println("Zoo - Errors");
                }
            }
            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Log.i("TAG", t.toString());
                System.out.println("Errors");
            }
        });
    }
}