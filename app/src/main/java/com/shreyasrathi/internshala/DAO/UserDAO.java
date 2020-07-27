package com.shreyasrathi.internshala.DAO;


import com.shreyasrathi.internshala.model.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {
   @Query("SELECT * FROM User WHERE Email =:email and Password =:password ")
    User getUser(String email,String password);

    @Insert
    void insert(User user);

}

