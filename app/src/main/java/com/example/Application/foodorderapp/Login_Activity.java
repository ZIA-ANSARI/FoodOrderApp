package com.example.Application.foodorderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends Activity {
    EditText mUsername, mPassword;
    Button buttonOne;

    public Login_Activity() {
    }
    //@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        buttonOne = (Button) findViewById(R.id.login);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                String sUsername = mUsername.getText().toString();
                String sPassword = mPassword.getText().toString();
                String type = "login";
                connect(type,sUsername,sPassword);
            }
        });

    }
    public void connect(String Type, String UserName, String PassWord)
    {

        BackgroundWorker backgroundWorker;
        backgroundWorker= new BackgroundWorker(this);
        backgroundWorker.execute(Type, UserName, PassWord);
    }

    public void ToDetail()
    {
        startActivity(new Intent(getApplicationContext(), DetailActivity.class));
    }
}