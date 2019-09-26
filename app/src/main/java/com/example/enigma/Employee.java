package com.example.enigma;

public class Employee {

    private int Id;
    private String Name;
    private String Contact;
    private String Email;
    private String Password;

    public Employee(){

    }

    public Employee(int id, String name, String contact, String email, String password) {
        Id = id;
        Name = name;
        Contact = contact;
        Email = email;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
