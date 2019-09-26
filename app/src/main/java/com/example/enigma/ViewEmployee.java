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


public class ViewEmployee extends Fragment {


    View v;
    private RecyclerView recyclerView;
    private List<Employee> ListEmployee;

    public ViewEmployee() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_view_employee, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        EmployeeViewAdapter recyclerViewAdapter = new EmployeeViewAdapter(getContext(), ListEmployee);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListEmployee = new ArrayList<>();
        //ListEmployee.add(new Employee("1","Name",""))
        ListEmployee.add(new Employee(1,"Name1","contact1","email1","password1"));
        ListEmployee.add(new Employee(2,"Name2","contact2","email2","password2"));
        ListEmployee.add(new Employee(3,"Name3","contact3","email3","password3"));
        ListEmployee.add(new Employee(4,"Name4","contact4","email4","password4"));
        ListEmployee.add(new Employee(5,"Name5","contact5","email5","password5"));
        ListEmployee.add(new Employee(6,"Name1","contact1","email1","password1"));
        ListEmployee.add(new Employee(7,"Name2","contact2","email2","password2"));
        ListEmployee.add(new Employee(8,"Name3","contact3","email3","password3"));
        ListEmployee.add(new Employee(9,"Name4","contact4","email4","password4"));
        ListEmployee.add(new Employee(10,"Name5","contact5","email5","password5"));
        ListEmployee.add(new Employee(11,"Name1","contact1","email1","password1"));
        ListEmployee.add(new Employee(12,"Name2","contact2","email2","password2"));
        ListEmployee.add(new Employee(13,"Name3","contact3","email3","password3"));
        ListEmployee.add(new Employee(14,"Name4","contact4","email4","password4"));
        ListEmployee.add(new Employee(15,"Name5","contact5","email5","password5"));


    }


}
