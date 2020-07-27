package com.shreyasrathi.internshala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shreyasrathi.internshala.DAO.UserDAO;
import com.shreyasrathi.internshala.DAO.UserDatabase;
import com.shreyasrathi.internshala.model.User;

public class MainActivity extends AppCompatActivity {

    Button btnSignin,btnSignup;
    EditText EmailId,Password;

    UserDAO db;
    UserDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this,UserDatabase.class,"User").allowMainThreadQueries().build();

        db = database.getUserData();

        btnSignin=findViewById(R.id.btnSignIn);
        btnSignup=findViewById(R.id.btnSignUp);
        EmailId=findViewById(R.id.edtEmail);
        Password=findViewById(R.id.edtPass);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String email = EmailId.getText().toString().trim();
                    String password = Password.getText().toString().trim();

                    User user = db.getUser(email,password);

                    if(user != null){
                        Intent i = new Intent(MainActivity.this, Home_Activity.class);
                        i.putExtra("User",email);
                        startActivity(i);
                    }else{
                        Toast.makeText(MainActivity.this, "Inncorrect User Registartion failed", Toast.LENGTH_SHORT).show();
                    }

            }catch (Exception e){
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });

    }
}
