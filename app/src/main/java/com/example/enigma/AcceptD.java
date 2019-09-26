package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcceptD extends AppCompatActivity {
    Button No, Yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_d);

        No = findViewById(R.id.btn_noD);
        Yes = findViewById(R.id.btn_yesD);

        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(No.getContext(),MainActivity.class);
                No.getContext().startActivity(intent);
            }

        });

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DeliveryInsert fragment = new DeliveryInsert();
                fm.beginTransaction().replace(R.id.accept_container,fragment).commit();
            }
        });


    }

}
