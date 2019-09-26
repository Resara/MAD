package com.example.enigma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeLogin extends AppCompatActivity {

    EditText em, psw;
    Button btnLogin;
    DatabaseHelperProduct db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_employee_login);

        db = new DatabaseHelperProduct(this);

        em = (EditText) findViewById(R.id.email);
        psw = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String email1 = em.getText().toString();
                String password1 = psw.getText().toString();


                if(email1.length() != 0){

                    if(password1.length() != 0){

                        boolean checkEP = db.emailPassword(email1, password1);

                        if (checkEP == true) {

                            Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(EmployeeLogin.this, MainActivity.class);
                            startActivity(intent);

                        }
                        else
                            Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getApplicationContext(), "Insert Password",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Insert Email",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
