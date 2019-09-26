package com.example.enigma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class purchaseItemEdit extends Fragment {

    DatabaseHelperProduct db;
    EditText pid,editTextQty,ItemName,Cname, address,price;
    Button button_update,button_delete;
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_purchase_item_edit, container, false);

        pid = v.findViewById(R.id.pId);
        ItemName = v.findViewById(R.id.itemName);
        Cname = v.findViewById(R.id.cname);
        address = v.findViewById(R.id.address);
        editTextQty = v.findViewById(R.id.editTextQty);
        price = v.findViewById(R.id.price);

        button_update = v.findViewById(R.id.button_update);
        button_delete = v.findViewById(R.id.button_delete);

        db = new DatabaseHelperProduct(this.getActivity());


        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pID = pid.getText().toString();
                String iName = ItemName.getText().toString();
                String cname = Cname.getText().toString();
                String add = address.getText().toString();
                String qty = editTextQty.getText().toString();
                String pri = price.getText().toString();

                if(pID.length() != 0){
                    if(iName.length() != 0){
                        if(cname.length() != 0){
                            if(add.length() != 0){
                                if(pri.length() != 0){
                                    if(qty.length() != 0){


                                            boolean isUpdated = db.updatePurchase(pID,iName,cname,add,pri,qty);

                                            if(isUpdated == true){
                                                Toast.makeText(getActivity(), "Purchase Updated", Toast.LENGTH_SHORT).show();
                                                pid.setText(" ");
                                                ItemName.setText(" ");
                                                Cname.setText(" ");
                                                address.setText(" ");
                                                editTextQty.setText(" ");
                                                price.setText(" ");

                                            }else{
                                                Toast.makeText(getActivity(),"Purchase Not Updated",Toast.LENGTH_LONG).show();
                                            }


                                    }else{
                                        Toast.makeText(getActivity(),"Insert Quantity",Toast.LENGTH_LONG).show();
                                    }
                                }else {
                                    Toast.makeText(getActivity(),"Insert Phone",Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getActivity(),"Insert Address",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getActivity(),"Insert Name",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getActivity(),"Insert Product",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(),"Insert Product ID",Toast.LENGTH_LONG).show();
                }





            }

        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRow = db.deleteItem(pid.getText().toString());

                if(deleteRow > 0){
                    Toast.makeText(getActivity(),"Item Deleted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(),"Incorrect ID",Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }

}

