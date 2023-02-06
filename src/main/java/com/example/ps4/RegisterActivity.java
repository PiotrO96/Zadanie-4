package com.example.ps4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private  EditText editTextPassword;
    private  EditText editTextFullName;
    private EditText editTextEmail;
    private Button buttonSave;
    private Button buttonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // setTitle(R.string.register);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try {
    DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext());
    Account account = new Account();
    account.setEmail(editTextEmail.getText().toString());
    account.setFullName(editTextFullName.getText().toString());
    account.setPassword(editTextPassword.getText().toString());
    account.setUsername(editTextUsername.getText().toString());
    Account temp = dataBaseHelper.checkUsername(editTextUsername.getText().toString());
    if (temp == null) {
        if (dataBaseHelper.create(account)) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.can_not_create);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
    else
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle(R.string.error);
        builder.setMessage(R.string.uzername_exists);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}
catch (Exception e)
{
    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
    builder.setTitle(R.string.error);
    builder.setMessage(e.getMessage());
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
        }
    });
    builder.show();
}
            }
        });
    }
}