package com.example.applestore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applestore.R;

import com.example.applestore.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    private Context context;
    private ArrayList<Order> orderList;

    public OrderAdapter(Context applicationContext, ArrayList<Order> orderList) {
        this.context = applicationContext;
        this.orderList = orderList;
    }
    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new OrderAdapter.OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.orderDate.setText(order.getNgayDatHang()+"");
        holder.orderAddress.setText(order.getDiaChi());
        holder.sumPrice.setText(order.getTongTien()+"");
        holder.orderStatus.setText(order.getTrangThai().getTenTrangThai()+"");

//        chưa viết onclick
    }

    @Override
    public int getItemCount() {
        return orderList.size();

    }
    public class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView orderDate,orderAddress,sumPrice,orderStatus;
        public CardView cardOrder;
        public OrderViewHolder(View itemView) {
            super(itemView);
            orderDate = itemView.findViewById(R.id.order_date);
            orderAddress = itemView.findViewById(R.id.order_address);
            sumPrice = itemView.findViewById(R.id.sum_price);
            orderStatus = itemView.findViewById(R.id.order_status);
            cardOrder = itemView.findViewById(R.id.card_order);
        }
    }
}
