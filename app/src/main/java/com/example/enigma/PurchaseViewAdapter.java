package com.example.enigma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PurchaseViewAdapter extends RecyclerView.Adapter<PurchaseViewAdapter.PurchaseViewHolder> {


    Context mContext;
    List<Purchase> purchaseList;

    public PurchaseViewAdapter(Context mContext, List<Purchase> purchaseList) {
        this.mContext = mContext;
        this.purchaseList = purchaseList;
    }

    @NonNull
    @Override
    public PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_view_purchase_card,parent,false);
        PurchaseViewHolder viewHolder = new PurchaseViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseViewAdapter.PurchaseViewHolder holder, int position) {

        holder.txtPurchaseID.setText(String.valueOf(purchaseList.get(position).getPurchaseID()));
        holder.txtProductName.setText(purchaseList.get(position).getProductName());
        holder.txtCustomerName.setText(purchaseList.get(position).getCustomerName());
        holder.txtQty.setText(String.valueOf(purchaseList.get(position).getQuantity()));
        holder.txtPrice.setText(String.valueOf(purchaseList.get(position).getPrice()));


    }

    @Override
    public int getItemCount() {
        return purchaseList.size();
    }

    public static class PurchaseViewHolder extends RecyclerView.ViewHolder{

        private TextView txtPurchaseID;
        private TextView txtProductName;
        private TextView txtCustomerName;
        private TextView txtQty;
        private TextView txtPrice;


        public PurchaseViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPurchaseID = (TextView) itemView.findViewById(R.id.purchaseID);
            txtProductName = (TextView) itemView.findViewById(R.id.ProductName);
            txtCustomerName = (TextView) itemView.findViewById(R.id.CustomerName);
            txtQty = (TextView) itemView.findViewById(R.id.qty);
            txtPrice = (TextView) itemView.findViewById(R.id.price);

        }
    }
}


