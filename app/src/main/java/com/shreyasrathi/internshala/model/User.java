package com.shreyasrathi.internshala.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int Id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    @NonNull
    public int getId() {
        return Id;
    }

    public void setId(@NonNull int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
