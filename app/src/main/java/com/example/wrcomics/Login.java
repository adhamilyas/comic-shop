package com.example.wrcomics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(!username.equals("") && !password.equals("") && username.length() >= 4 && username.length() <= 8){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);

                    startActivity(intent);
                } else if(username.equals("")){
                    Toast.makeText(getApplicationContext(), "Username cannot be empty", Toast.LENGTH_SHORT).show();
                } else if(password.equals("")){
                    Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if(username.length() < 4 || username.length() > 8){
                    Toast.makeText(getApplicationContext(), "Username must be greater than 4 and less than 8 characters", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}