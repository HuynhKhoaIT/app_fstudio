package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.applestore.R;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;

public class DetailProductActivity extends AppCompatActivity {
    TextView detailName,detailPrice, detailDes;
    ImageView detailImage;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        detailName = findViewById(R.id.name_product);
        detailPrice = findViewById(R.id.price_product);
        detailDes = findViewById(R.id.des_product);
        detailImage = findViewById(R.id.img_product);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailName.setText(bundle.getString("Title"));
            detailPrice.setText(bundle.getString("Price"));
            detailDes.setText(bundle.getString("Desc"));
            //detailImage.setImageResource(bundle.getInt("Image"));
            Glide.with(context).load(bundle.getString("Image")).into(detailImage);
        }
    }
}