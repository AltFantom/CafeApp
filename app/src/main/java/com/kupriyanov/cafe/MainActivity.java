package com.kupriyanov.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonSignIn;
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString().trim();
                String userPassword = editTextPassword.getText().toString().trim();

                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.error_fields_empty,
                            Toast.LENGTH_SHORT).show();
                } else {
                    launchNextScreen(userName);
                }
            }
        });
    }

    private void launchNextScreen(String userName){
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }

    private void initViews() {
        buttonSignIn = findViewById(R.id.buttonSignIn);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

}