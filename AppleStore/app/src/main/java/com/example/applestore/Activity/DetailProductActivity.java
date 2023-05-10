package com.example.applestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applestore.R;

public class DetailProductActivity extends AppCompatActivity {
    TextView detailName,detailPrice, detailDes;
    ImageView detailImage;
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
            detailImage.setImageResource(bundle.getInt("Image"));
        }
    }
}