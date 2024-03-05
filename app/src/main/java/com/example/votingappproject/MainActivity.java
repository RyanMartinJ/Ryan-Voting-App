package com.example.votingappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText textUser;
    private EditText textPw;
    private Button lgIn;
    private TextView loginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_login);

        textUser =(EditText) findViewById(R.id.userName);
        textPw = (EditText) findViewById(R.id.password);

        lgIn = (Button) findViewById(R.id.btnDisplay);
        //loginStatus = (TextView) findViewById(R.id.lgStat);

        lgIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = "Rsol";
                String pw = "user";

                if (un.equals(textUser.getText().toString()) && pw.equals(textPw.getText().toString())){

                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();

                    // Start the VotingActivity
                    Intent intent = new Intent(MainActivity.this, VotingActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}