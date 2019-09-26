package com.example.enigma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewPurchases.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewPurchases#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPurchases extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Purchase> listPurchase;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_view_purchases,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        PurchaseViewAdapter recyclerAdapter = new PurchaseViewAdapter(getContext(), listPurchase);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPurchase = new ArrayList<>();
        listPurchase.add(new Purchase(1,"Product1","cusName1",2,800.0));
        listPurchase.add(new Purchase(2,"Product2","cusName2",2,800.0));
        listPurchase.add(new Purchase(3,"Product3","cusName3",2,800.0));
        listPurchase.add(new Purchase(4,"Product4","cusName4",2,800.0));
        listPurchase.add(new Purchase(5,"Product5","cusName5",2,800.0));
        listPurchase.add(new Purchase(6,"Product6","cusName6",2,800.0));
        listPurchase.add(new Purchase(7,"Product7","cusName7",2,800.0));
        listPurchase.add(new Purchase(8,"Product8","cusName8",2,800.0));

    }
}
