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

public class insertItem1 extends Fragment {

    EditText itemName,cname,address,price,qty;
    Button btnAdd,btnViewAll;
    //DatabaseHelperR myDb;
    DatabaseHelperProduct myDb;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_insert_item,null);
        //myDb = new DataBaseHelperR(this.getActivity());
        myDb = new DatabaseHelperProduct((this.getActivity()));

        itemName = (EditText)v.findViewById(R.id.itemName);
        cname = (EditText)v.findViewById(R.id.cname);
        address = (EditText)v.findViewById(R.id.address);
        price = (EditText)v.findViewById(R.id.price);
        qty = (EditText)v.findViewById(R.id.qty);
        btnAdd = (Button)v.findViewById(R.id.btnAdd);
        btnViewAll = (Button)v.findViewById(R.id.btnViewAllpur);
        additem();
        viewPurchases();

        /*btnAdd = v.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


        return  v;

    }

    public void additem(){

        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          boolean isInserted =  myDb.insertPurchase(itemName.getText().toString(),cname.getText().toString(),address.getText().toString(),
                                                  price.getText().toString(),qty.getText().toString());

                                          if (isInserted == true) {
                                              Toast.makeText(getActivity(),"Item Added", Toast.LENGTH_LONG).show();
                                              //Toast.makeText(additem_fragment.this, "Item Added", Toast.LENGTH_LONG).show();
                                              itemName.setText("");
                                              cname.setText("");
                                              address.setText("");
                                              price.setText("");
                                              qty.setText("");
                                          }
                                          else
                                              Toast.makeText(getActivity(),"Item Not Added", Toast.LENGTH_LONG).show();

                                      }
                                  }
        );
    }

    public void viewPurchases(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllPurchases();
                if(res.getCount() == 0){
                    //Toast.makeText(getActivity(),"No Delivery to show",Toast.LENGTH_LONG).show();
                    showMessage("Error","No Purchase Found");
                    return;
                }


                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Purchase ID: " +res.getString(0)+ "\n");
                    buffer.append("Item Name: " +res.getString(1)+ "\n");
                    buffer.append("Customer Name: " +res.getString(2)+ "\n");
                    buffer.append("Address: " +res.getString(3)+ "\n");
                    buffer.append("Price: " +res.getString(4)+ "\n");
                    buffer.append("Quantity: " +res.getString(5)+ "\n\n");

                }

                showMessage("Purchase",buffer.toString());
            }
        });
    }



    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }



}
