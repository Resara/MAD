package com.example.enigma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryViewAdapter extends RecyclerView.Adapter<DeliveryViewAdapter.DeliveryViewHolder> {


    Context mContext;
    List<Delivery> mData;


    public DeliveryViewAdapter(Context mContext, List<Delivery> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public DeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_view_delivery_card,parent,false);
        DeliveryViewHolder viewHolder = new DeliveryViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryViewHolder holder, int position) {

        holder.txtName.setText(mData.get(position).getCustomerName());
        holder.txtAddress.setText(mData.get(position).getAddress());
        holder.txtPhone.setText(mData.get(position).getPhone());
        holder.txtProID.setText(String.valueOf(mData.get(position).getProID()));
        holder.txtProName.setText(String.valueOf(mData.get(position).getProName()));
        holder.txtQty.setText(String.valueOf(mData.get(position).getQuantity()));
        holder.txtPrice.setText(String.valueOf(mData.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class DeliveryViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView txtAddress;
        private TextView txtPhone;
        private TextView txtProID;
        private TextView txtProName;
        private TextView txtQty;
        private TextView txtPrice;




        public DeliveryViewHolder(View deliveryView){
            super(deliveryView);

            txtName = (TextView) deliveryView.findViewById(R.id.txtProID);
            txtAddress = (TextView) deliveryView.findViewById(R.id.txtProName);
            txtPhone = (TextView) deliveryView.findViewById(R.id.txtPhone);
            txtProID = (TextView) deliveryView.findViewById(R.id.txtCusName);
            txtProName = (TextView) deliveryView.findViewById(R.id.txtCusAddress);
            txtQty = (TextView) deliveryView.findViewById(R.id.txtQty);
            txtPrice = (TextView) deliveryView.findViewById(R.id.txtPrice);



        }



    }
}
