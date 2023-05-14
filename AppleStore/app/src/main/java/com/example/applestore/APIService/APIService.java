package com.example.applestore.APIService;

import com.example.applestore.model.Cart;
import com.example.applestore.model.Blog;
import com.example.applestore.model.CartDetail;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;
import com.example.applestore.model.User;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIService {
    //ServiceAPI
    APIService serviceapi = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/myapp/")
            .build()
            .create(APIService.class);
    // San Pham
    @GET("sanpham")
    Call<List<Product>> getAllProduct();
    @GET("sanpham-by-dm")
    Call<List<Product>> getSanPhamByDanhMuc(@Query("maDM") int maDM);
    @GET("top8")
    Call<List<Product>> getTop8Product();

    // Danh Muc
    @GET("danhmuc")
    Call<List<Category>> getAllCategory();
    @POST("danhmuc")
    Call<Category> createCategory(@Body Category category) ;

    // User
    @POST("khachhang")
    Call<User> createUser(@Body User user);
    @FormUrlEncoded
    @POST("khachhang-login")
    Call<User> loginUser(@Field("email") String username, @Field("password") String password);
    // Cart
    @POST("giohang")
    Call<Cart> createCart(@Body Cart cart);
    @GET("giohangbymakh")
    Call<Cart> getGioHangBymaKH(@Query("id") int maKH);
    //Blog
    @GET("baiviet")
    Call<List<Blog>> getAllBlog();
    //DetailCart
    @GET("ctgh")
    Call<CartDetail> addProductToCart(@Body CartDetail cartDetail);


}
