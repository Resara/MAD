package com.example.enigma;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewDelivery.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewDelivery#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ViewDelivery extends Fragment{

    View v;
    RecyclerView recyclerView;
    DeliveryViewAdapter adapterdel;
    DatabaseHelperProduct delDB;
    Button btnViewAll;

    List<Delivery> deliveryList;
    //private RecyclerView RecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_view_delivery,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        DeliveryViewAdapter recycleAdapter = new DeliveryViewAdapter(getContext(),deliveryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleAdapter);

        btnViewAll = v.findViewById(R.id.viewAll);

        delDB = new DatabaseHelperProduct(this.getActivity());

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = delDB.getAllDelivery();
                if(res.getCount() == 0){
                    showMessage("Error","No Delivery Found");
                    return;
                }


                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){
                    buffer.append("ID: " +res.getString(0)+ "\n");
                    buffer.append("Customer: " +res.getString(2)+ "\n");
                    buffer.append("Address: " +res.getString(3)+ "\n");
                    buffer.append("Phone: " +res.getString(4)+ "\n");
                    buffer.append("Product: " +res.getString(1)+ "\n");
                    buffer.append("Quantity: " +res.getString(5)+ "\n");
                    buffer.append("Price: " +res.getString(6)+ "\n\n");
                }

                showMessage("Delivery",buffer.toString());

            }

        });

        return v;
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.id.de);
        deliveryList = new ArrayList<>();
        /*recyclerView = (RecyclerView)recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        delDB = new DatabaseHelperProduct(getActivity());*/

        deliveryList.add(new Delivery("cus1","add1","phone1",1,"pro1",2,600.00));
        deliveryList.add(new Delivery("cus2","add2","phone2",2,"pro2",2,600.00));
        deliveryList.add(new Delivery("cus3","add3","phone3",3,"pro3",3,600.00));
        deliveryList.add(new Delivery("cus4","add4","phone4",4,"pro4",4,600.00));
        deliveryList.add(new Delivery("cus5","add5","phone5",11,"pro5",5,600.00));
        deliveryList.add(new Delivery("cus6","add6","phone6",3,"pro6",1,600.00));
        deliveryList.add(new Delivery("cus7","add7","phone7",4,"pro7",2,600.00));
        deliveryList.add(new Delivery("cus8","add8","phone8",1,"pro8",2,600.00));

        /*Cursor res = delDB.getAllDelivery();

        if(res.getCount() == 0){
            return;
        }

        while(res.moveToNext()){
            int proID = Integer.parseInt(res.getString(0));
            String cusName = res.getString(1);
            String address = res.getString(2);
            String phone = res.getString(3);
            String product = res.getString(4);
            int qty = Integer.parseInt(res.getString(5));
            double price = Integer.parseInt(res.getString(6));

            deliveryList.add(new Delivery(cusName,address,phone,proID,product,qty,price));

        }

        adapterdel = new DeliveryViewAdapter(getActivity(),deliveryList);
        recyclerView.setAdapter(adapterdel);*/


    }

}
