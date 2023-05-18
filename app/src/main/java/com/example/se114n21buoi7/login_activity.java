package com.example.se114n21buoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        Database database = new Database(login_activity.this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = editTextUsername.getText().toString().trim();
                String Password = editTextPassword.getText().toString().trim();
                String sql = "SELECT * FROM Account WHERE Username ='" + Username + "' AND Password = '"+Password +"'";
                Cursor cursor = database.GetData(sql);
                if (cursor.getCount()>0){
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}