package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import com.example.applestore.R;
import com.example.applestore.model.Product;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    Context context = this;
    //    RecyclerView rccate;
    List<Product> productList;
    public static final String KEY_PRODUCT_ID_TO_PRODUCT_DETAIL = "KEY_PRODUCT_ID_TO_PRODUCT_DETAIL";
    //view
    GridView gvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

    }
}