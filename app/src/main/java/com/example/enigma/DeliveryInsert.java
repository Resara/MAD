package com.example.enigma;

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

import java.util.InputMismatchException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeliveryInsert.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeliveryInsert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveryInsert extends Fragment {

    EditText txtProID, txtproName, txtcusName, txtAddress,txtPhone, txtQty, txtPrice;
    Button btnAddDelivery,btnClear;
    View view;
    DatabaseHelperProduct db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_delivery_insert,container,false);

        txtcusName = view.findViewById(R.id.txtCusName);
        txtAddress = view.findViewById(R.id.txtCusAddress);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtProID = view.findViewById(R.id.txtProID);
        txtproName = view.findViewById(R.id.txtProName);
        txtQty = view.findViewById(R.id.txtQty);
        txtPrice = view.findViewById(R.id.txtPrice);

        btnAddDelivery = view.findViewById(R.id.btnAddDelivery);
        btnClear = view.findViewById(R.id.btnClear);

        db = new DatabaseHelperProduct(this.getActivity());

        //uvini insert
        btnAddDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String cusName = txtcusName.getText().toString();
                String address = txtAddress.getText().toString();
                String phone = txtPhone.getText().toString();
                String proID = txtProID.getText().toString();
                String proName = txtproName.getText().toString();
                String qty = txtQty.getText().toString();
                String price = txtPrice.getText().toString();

                int pID = Integer.parseInt(proID);
                int Qty = Integer.parseInt(qty);
                double Price = Double.parseDouble(price);

                long l = db.addDelivery(pID,proName,cusName,address,phone,Qty,Price);

                db.addDelivery(
                        txtcusName.getText().toString(),
                        txtAddress.getText().toString(),
                        txtPhone.getText().toString(),
                        Integer.parseInt(txtProID.getText().toString()),
                        txtproName.getText().toString(),
                        Integer.valueOf(txtQty.getText().toString()),
                        Double.valueOf(txtPrice.getText().toString())

                );*/

                /*int ProID = Integer.parseInt(txtProID.getText().toString());
                String address = txtAddress.getText().toString();
                String phone = txtPhone.getText().toString();
                String cusName = txtcusName.getText().toString();
                String ProName = txtproName.getText().toString();
                int qty = Integer.parseInt(txtQty.getText().toString());
                double price = Double.parseDouble(txtPrice.getText().toString());*/

                String ProID = txtProID.getText().toString();
                String address = txtAddress.getText().toString();
                String phone = txtPhone.getText().toString();
                String cusName = txtcusName.getText().toString();
                String ProName = txtproName.getText().toString();
                String qty = txtQty.getText().toString();
                String price = txtPrice.getText().toString();

                if (ProID.length() != 0){
                    if (ProName.length() != 0) {
                        if (cusName.length() != 0) {
                            if (address.length() != 0) {
                                if (phone.length() != 0) {
                                    if (qty.length() != 0) {
                                        if (price.length() != 0) {
                                            try {
                                                Delivery del = new Delivery();
                                                del.setProID(Integer.parseInt(ProID));
                                                del.setProName(ProName);
                                                del.setCustomerName(cusName);
                                                del.setAddress(address);
                                                del.setPhone(phone);
                                                del.setQuantity(Integer.parseInt(qty));
                                                del.setPrice(Integer.parseInt(price));

                                                boolean i = db.addDelivery(del);

                                                if (i) {
                                                    Toast.makeText(getActivity(), "Delivery Added Succssfully", Toast.LENGTH_LONG).show();
                                                    txtProID.setText("");
                                                    txtproName.setText("");
                                                    txtPhone.setText("");
                                                    txtcusName.setText("");
                                                    txtAddress.setText("");
                                                    txtQty.setText("");
                                                    txtPrice.setText("");
                                                } else {
                                                    Toast.makeText(getActivity(), "Fail to add the Delivery", Toast.LENGTH_LONG).show();
                                                }

                                            } catch (InputMismatchException s) {
                                                Toast.makeText(getActivity(), "Invalid Type", Toast.LENGTH_LONG).show();
                                            } catch (NumberFormatException e) {
                                                Toast.makeText(getActivity(), "Invalid Data Type Entered", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtcusName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtProID.setText("");
                txtproName.setText("");
                txtQty.setText("");
                txtPrice.setText("");
            }
        });

        return  view;

    }
}
