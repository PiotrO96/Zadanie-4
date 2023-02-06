package com.example.ps4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private  EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername= findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext());
String username = editTextUsername.getText().toString();
String password = editTextPassword.getText().toString();
Account account = dataBaseHelper.login(username,password);
if ( account == null)
{
    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
    builder.setTitle(R.string.error);
    builder.setMessage(R.string.invalid_account);
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });
    builder.show();

}
else {
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
         intent.putExtra("account",account);
         startActivity(intent);

}
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}