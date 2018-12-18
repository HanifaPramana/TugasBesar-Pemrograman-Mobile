package com.example.lim.kulinermalang;

//kelas untuk menset data user berupa id, username, email dan password
public class User {
    public String id;
    public String userName;
    public String email;
    public String password;

    //method untuk mengenalkan beberapa parameter
    public User(String id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}