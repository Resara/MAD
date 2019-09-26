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
import androidx.fragment.app.FragmentTransaction;


public class RegisterEmployee extends Fragment {

    EditText SearchID, Name, Contact, Email, Password, ConfirmPassword;
    Button btnRegister, btnUpdate, btnDelete, btnClear, btnViewAll, btnSearch, getBtnViewAll1;
    DatabaseHelperProduct db;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_register_employee,container,false);

        SearchID = (EditText) v.findViewById(R.id.Search);
        Name = (EditText) v.findViewById(R.id.Name);
        Contact = (EditText) v.findViewById(R.id.Contact);
        Email = (EditText) v.findViewById(R.id.Email);
        Password = (EditText) v.findViewById(R.id.Password);
        ConfirmPassword = (EditText) v.findViewById(R.id.ConfirmPassword);

        btnRegister = (Button) v.findViewById(R.id.btnRegister);
        btnUpdate = (Button) v.findViewById(R.id.btnUpdate);
        btnDelete = (Button) v.findViewById(R.id.btnDelete);
        btnClear = (Button) v.findViewById(R.id.btnClear);
        btnViewAll = (Button) v.findViewById(R.id.btnViewAll);
        btnSearch = (Button) v.findViewById(R.id.btnSearch);
        getBtnViewAll1 = (Button) v.findViewById(R.id.btnViewAll1);

        db = new DatabaseHelperProduct(this.getActivity());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString();
                String contact = Contact.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString();

                if (name.equals("") || contact.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(getActivity(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(confirmPassword)){

                        boolean checkEmail = db.checkEmail(email);

                        if (checkEmail == true){

                            Employee emp = new Employee();

                            emp.setName(name);
                            emp.setContact(contact);
                            emp.setEmail(email);
                            emp.setPassword(password);

                            boolean insert = db.addEmployee(emp);

                            if (insert == true){

                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                                Name.setText("");
                                Contact.setText("");
                                Email.setText("");
                                Password.setText("");
                                ConfirmPassword.setText("");

                           }
                        }
                        else{
                            Toast.makeText(getActivity(), "Email Already Exists ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name.setText("");
                Contact.setText("");
                Email.setText("");
                Password.setText("");
                ConfirmPassword.setText("");
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.screen_area,new ViewEmployee());
                ft.commit();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SearchID.getText().toString();
                String n = Name.getText().toString();
                String c = Contact.getText().toString();
                String e = Email.getText().toString();
                String p = Password.getText().toString();
                String cp = ConfirmPassword.getText().toString();

                if(s.length() != 0){

                    if(n.length() != 0){

                        if(c.length() != 0){

                            if(e.length() != 0){

                                if(p.length() != 0){

                                    if(cp.length() != 0){

                                        if (p.equals(cp)){
                                            boolean isUpdate = db.updateEmployee(s,n,c,e,p);

                                            if(isUpdate == true) {

                                                Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();

                                                SearchID.setText("");
                                                Name.setText("");
                                                Contact.setText("");
                                                Email.setText("");
                                                Password.setText("");
                                                ConfirmPassword.setText("");


                                            }else{
                                                Toast.makeText(getActivity(), "Data not Updated",Toast.LENGTH_LONG).show();
                                            }
                                        }else{
                                            Toast.makeText(getActivity(), "Password do not match",Toast.LENGTH_LONG).show();
                                        }

                                    }else{
                                        Toast.makeText(getActivity(), "Insert Confirm Password",Toast.LENGTH_LONG).show();
                                    }

                                }else{
                                    Toast.makeText(getActivity(), "Insert Password",Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getActivity(), "Insert Email",Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(getActivity(), "Insert Contact Number",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getActivity(), "Insert Name",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Insert Employee ID",Toast.LENGTH_LONG).show();
                }
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deleteRow = db.deleteEmployee(SearchID.getText().toString());

                if(deleteRow > 0){
                    Toast.makeText(getActivity(), "Employee Record Deleted Successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Select the correct ID to Delete",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = SearchID.getText().toString();
                String n1 = Name.getText().toString();
                String c1 = Contact.getText().toString();
                String e1 = Email.getText().toString();
                String p1 = Password.getText().toString();
                String cp1 = ConfirmPassword.getText().toString();


            }
        });

        getBtnViewAll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getAllEmployee();

                if (res.getCount() == 0){

                    //show message
                    showMessageEmp("Error", "Nothing Found");

                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){
                    buffer.append("ID : " + res.getString(0) + "\n");
                    buffer.append("Name : " + res.getString(1) + "\n");
                    buffer.append("Contact : " + res.getString(2) + "\n");
                    buffer.append("Email : " + res.getString(3) + "\n");
                    buffer.append("Password : " + res.getString(4) + "\n\n");

                }
                //show all employee
                showMessageEmp("Employee Details", buffer.toString());
            }
        });


        return v;
    }

    public void showMessageEmp (String title, String message){
        AlertDialog.Builder builder  =new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
