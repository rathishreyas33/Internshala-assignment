package com.shreyasrathi.internshala.DAO;

import com.shreyasrathi.internshala.model.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO getUserData();
}
