package com.example.enigma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeViewAdapter extends RecyclerView.Adapter<EmployeeViewAdapter.EmployeeViewHolder>{


    Context mContext;
    List<Employee> employeeList;

    public EmployeeViewAdapter(Context mContext, List<Employee> employeeList){
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_view_employee_card,parent,false);
        EmployeeViewHolder viewHolder = new EmployeeViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        holder.txtId.setText(String.valueOf(employeeList.get(position).getId()));
        holder.txtName.setText(employeeList.get(position).getName());
        holder.txtContact.setText(employeeList.get(position).getContact());
        holder.txtEmail.setText(employeeList.get(position).getEmail());
        holder.txtPassword.setText(employeeList.get(position).getPassword());
    }


    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder{


        private TextView txtId;
        private TextView txtName;
        private TextView txtContact;
        private TextView txtEmail;
        private TextView txtPassword;

        public EmployeeViewHolder(View employeeView){
            super(employeeView);

            txtId = (TextView)employeeView.findViewById(R.id.empID);
            txtName = (TextView)employeeView.findViewById(R.id.empName);
            txtContact = (TextView)employeeView.findViewById(R.id.contactno);
            txtEmail = (TextView)employeeView.findViewById(R.id.mail);
            txtPassword = (TextView)employeeView.findViewById(R.id.psw);

        }
    }
}
