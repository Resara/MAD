package com.example.enigma;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapterhome extends RecyclerView.Adapter<ProductAdapterhome.productViewHolder> {

    private Context mCtx;
    List<Product> productList;


    public ProductAdapterhome(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view  = inflater.inflate(R.layout.product_layout,null);
        return new productViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final productViewHolder holder, int position) {
        Product product = productList.get(position);

        // holder.textViewId.setText(product.getId());
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewId.setText(String.valueOf(product.getId()));

        holder.btnpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.btnpurchase.getContext(),AcceptP.class);
                holder.btnpurchase.getContext().startActivity(intent);
            }
        });

        holder.btndelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.btndelivery.getContext(),AcceptD.class);
                holder.btndelivery.getContext().startActivity(intent);
            }
        });
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class productViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating, textViewPrice,textViewId;
        Button btnpurchase, btndelivery;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textVID);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc  = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            btnpurchase = itemView.findViewById(R.id.btnP);
            btndelivery = itemView.findViewById(R.id.btnD);


        }
    }


    public void filterList(ArrayList<Product> filteredList){
        productList = filteredList;
        notifyDataSetChanged();
    }
}
