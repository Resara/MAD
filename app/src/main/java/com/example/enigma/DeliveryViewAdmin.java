package com.example.enigma;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeliveryViewAdmin.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeliveryViewAdmin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveryViewAdmin extends Fragment {

    EditText txtProID, txtProName, txtcusName, txtcusAddress, txtPhone, txtQty, txtPrice;
    Button btnUpdateDelivery, btnDeleteDelivery,btnViewDelivery,btnClear;
    View v;
    DatabaseHelperProduct db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_delivery_view_admin,container,false);

        txtProID = v.findViewById(R.id.txtProID);
        txtProName = v.findViewById(R.id.txtProName);
        txtcusName = v.findViewById(R.id.txtCusName);
        txtcusAddress = v.findViewById(R.id.txtCusAddress);
        txtPhone = v.findViewById(R.id.txtPhone);
        txtQty = v.findViewById(R.id.txtQty);
        txtPrice= v.findViewById(R.id.txtPrice);

        btnDeleteDelivery = v.findViewById(R.id.btnDeleteDelivery);
        btnUpdateDelivery = v.findViewById(R.id.btnUpdateDelivery);
        btnViewDelivery = v.findViewById(R.id.btnViewDelivery);
        btnClear = v.findViewById(R.id.btnClear);


        db = new DatabaseHelperProduct(this.getActivity());

        btnUpdateDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proID = txtProID.getText().toString();
                String proName = txtProName.getText().toString();
                String CusName = txtcusName.getText().toString();
                String cusAddress = txtcusAddress.getText().toString();
                String phone = txtPhone.getText().toString();
                String qty = txtQty.getText().toString();
                String price = txtPrice.getText().toString();

                if(proID.length() != 0){
                    if(proName.length() != 0){
                        if(CusName.length() != 0){
                            if(cusAddress.length() != 0){
                                if(phone.length() != 0){
                                    if(qty.length() != 0){
                                        if(price.length() != 0){

                                            boolean isUpdated = db.updateDelivery(proID,proName,CusName,cusAddress,phone,qty,price);

                                            if(isUpdated == true){
                                                Toast.makeText(getActivity(), "Delivery Updated", Toast.LENGTH_SHORT).show();
                                                txtProID.setText("");
                                                txtProName.setText("");
                                                txtcusName.setText("");
                                                txtcusAddress.setText("");
                                                txtPhone.setText("");
                                                txtQty.setText("");
                                                txtPrice.setText("");
                                            }else{
                                                Toast.makeText(getActivity(),"Delivery Not Updated",Toast.LENGTH_LONG).show();
                                            }

                                        }else{
                                            Toast.makeText(getActivity(),"Insert Price",Toast.LENGTH_LONG).show();
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

                /*if(proID.length() != 0){
                    boolean isUpdated = db.updateDelivery(proID,proName,CusName,cusAddress,phone,qty,price);

                    if(isUpdated == true) {
                        Toast.makeText(getActivity(), "Delivery Updated", Toast.LENGTH_SHORT).show();
                        txtProID.setText("");
                        txtProName.setText("");
                        txtcusName.setText("");
                        txtcusAddress.setText("");
                        txtPhone.setText("");
                        txtQty.setText("");
                        txtPrice.setText("");
                    }else{
                        Toast.makeText(getActivity(),"Delivery Not Updated",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getActivity(),"Enter Delivery ID",Toast.LENGTH_LONG).show();

                }*/
            }
        });

        btnDeleteDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRow = db.deleteDelivery(txtProID.getText().toString());

                if(deleteRow > 0){
                    Toast.makeText(getActivity(),"Delivery Deleted",Toast.LENGTH_LONG).show();
                    txtProID.setText("");
                }else{
                    Toast.makeText(getActivity(),"Incorrect ID",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnViewDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getAllDelivery();
                if(res.getCount() == 0){
                    //Toast.makeText(getActivity(),"No Delivery to show",Toast.LENGTH_LONG).show();
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

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtProID.setText("");
                txtProName.setText("");
                txtcusName.setText("");
                txtcusAddress.setText("");
                txtPhone.setText("");
                txtQty.setText("");
                txtPrice.setText("");
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


}
