package com.example.applestore.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.applestore.Adapter.ProductAdapter;
import com.example.applestore.R;
import com.example.applestore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView mRecyclerView;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.imageSlide);

        mRecyclerView = view.findViewById(R.id.product_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(R.drawable.ipad, "Ipad", 100, 1, 10,"Mô tả chi tiết");
        Product product2 = new Product(R.drawable.iphone, "Iphone 14", 25666000, 2, 5, "Mô tả chi tiết nè");
        Product product3 = new Product(R.drawable.mac, "Macbook", 3200000, 3, 8, "Mô tả nữa nè");
        Product product4 = new Product(R.drawable.watch, "Apple Watch", 1599000,4, 10, "Mô tả đây nha");
        Product product5 = new Product(R.drawable.airtag, "tai nghe", 1390000,5, 9 ," Mô tả nè ba");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        ProductAdapter adapter = new ProductAdapter(productList);
        mRecyclerView.setAdapter(adapter);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bn1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bnfstudio, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bn2, ScaleTypes.FIT));
        imageSlider.startSliding(3000);
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }
}