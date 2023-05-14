package com.example.applestore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applestore.R;
import com.example.applestore.Utils.CurrencyFormatter;
import com.example.applestore.model.CartDetail;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private Context context;
    private List<CartDetail> listCartDetail;

    public CartAdapter(Context applicationContext, List<CartDetail> listCartDetail) {
        this.context = applicationContext;
        this.listCartDetail = listCartDetail;
    }
    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new CartAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        CartDetail cartDetail = listCartDetail.get(position);

        holder.productName.setText(cartDetail.getSanPham3().getTenSP());
        holder.productPrice.setText(CurrencyFormatter.formatCurrency(cartDetail.getSanPham3().getGiaBanThuong()));
        Glide.with(context).load(cartDetail.getSanPham3().getAnh()).into(holder.productImage);
        holder.productAmount.setText(cartDetail.getSoLuong());

    }
    @Override
    public int getItemCount() {
        return listCartDetail.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public Button btnMinus;
        public TextView productAmount;
        public Button btnPlus;


//        public CardView item_Cart;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            btnMinus = itemView.findViewById(R.id.quantity_minus_btn);
            productAmount = itemView.findViewById(R.id.quantity_text_view);
            btnPlus = itemView.findViewById(R.id.quantity_plus_button);
        }
    }
}
