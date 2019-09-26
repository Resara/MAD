package com.example.enigma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AdminLogin extends Fragment {


    EditText txtp,txte;
    View v;
    Button btnadminfr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_admin_login, container, false);

        Button btnadminfr = (Button)view.findViewById(R.id.btn_loginadmin);

        txte= view.findViewById(R.id.et_email);
        txtp= view.findViewById(R.id.et_password);


        btnadminfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String AdminE = txte.getText().toString();
                String AdminP = txtp.getText().toString();

                if(AdminE.length() != 0){

                    if(AdminP.length() != 0){

                        if(AdminE.equals("Admin") && AdminP.equals("123")){

                            Toast.makeText(getActivity(), "Welcome Admin",Toast.LENGTH_LONG).show();

                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.screen_area,new panel());
                            ft.commit();
                        }

                        else{
                            Toast.makeText(getActivity(), "Incorrect Email And Password ",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(getActivity(), "Insert Password",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Insert Email",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

}

