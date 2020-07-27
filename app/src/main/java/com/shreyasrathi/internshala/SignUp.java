package com.shreyasrathi.internshala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.shreyasrathi.internshala.DAO.UserDAO;
import com.shreyasrathi.internshala.DAO.UserDatabase;
import com.shreyasrathi.internshala.model.User;

public class SignUp extends AppCompatActivity {

    EditText etName,etEmailId,etPassword,etConPass;
    Button btnSign;
    TextView tvGotoLogIn;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName=findViewById(R.id.edtName);
        etEmailId=findViewById(R.id.edtEmailId);
        etPassword=findViewById(R.id.edtPassword);
        etConPass=findViewById(R.id.edtConfirmPass);
        btnSign=findViewById(R.id.bSignUp);
        tvGotoLogIn=findViewById(R.id.tvgotoLogin);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etName.equals("")||!etEmailId.equals("")||!etPassword.equals("")||!etConPass.equals("")) {

                    String name = etName.getText().toString().trim();
                    String email = etEmailId.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    User user = new User(name, email, password);
                    userDAO.insert(user);
                    Intent gotoLogin = new Intent(SignUp.this, MainActivity.class);
                    startActivity(gotoLogin);
                    Toast.makeText(SignUp.this, "succesful", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Registered Sucessfully", Snackbar.LENGTH_SHORT).show();

                }
                else if(!etName.getText().toString().trim().matches("[a-zA-Z]")){
                        etName.requestFocus();
                        etName.setError("Enter valid Name");
                    }
                    else if (!etEmailId.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                        etEmailId.requestFocus();
                        etEmailId.setError("Invalid Email Address");
                    }
                    else if(!etPassword.getText().toString().equals(etConPass.getText().toString())) {
                    etConPass.requestFocus();
                    etConPass.setError("Password Doesnt Match");
                }
            }
        });

        tvGotoLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,MainActivity.class));
            }
        });

        userDAO = Room.databaseBuilder(this, UserDatabase.class, "User").allowMainThreadQueries().build().getUserData();



    }
}
