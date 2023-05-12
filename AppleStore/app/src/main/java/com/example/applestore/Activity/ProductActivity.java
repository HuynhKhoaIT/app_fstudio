package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.applestore.R;
import com.example.applestore.model.Product;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    Context context = this;
    List<Product> productList;
    public static final String KEY_PRODUCT_ID_TO_PRODUCT_DETAIL = "KEY_PRODUCT_ID_TO_PRODUCT_DETAIL";
    //view
    RecyclerView recProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recProduct = findViewById(R.id.product_list);
    }
}