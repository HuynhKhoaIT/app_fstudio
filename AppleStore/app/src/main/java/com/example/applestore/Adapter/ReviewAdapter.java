package com.example.applestore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applestore.R;
import com.example.applestore.Utils.CurrencyFormatter;
import com.example.applestore.model.OrderDetail;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    public static final String KEY_ORDERID_TO_PRODUCT = "KEY_CATEGORYID_TO_PRODUCT";
    Context context;
    ArrayList<OrderDetail> listOrderDetail;

    public ReviewAdapter(Context context, ArrayList<OrderDetail> listOrderDetail) {
        this.context = context;
        this.listOrderDetail = listOrderDetail;
    }
    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_order, parent, false);
        return new ReviewAdapter.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        // set date
        Glide.with(context).load(listOrderDetail.get(position).getSanPham2().getAnh()).into(holder.productImage);
        holder.productName.setText(listOrderDetail.get(position).getSanPham2().getTenSP());
        holder.productPrice.setText(CurrencyFormatter.formatCurrency(listOrderDetail.get(position).getSanPham2().getGiaBanThuong()));
    }
    @Override
    public int getItemCount() {
        return listOrderDetail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName,productPrice;
        RatingBar productRatingBar;
        EditText reviewEditText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productRatingBar = itemView.findViewById(R.id.productRatingBar);
            reviewEditText = itemView.findViewById(R.id.reviewEditText);

        }
    }
}
