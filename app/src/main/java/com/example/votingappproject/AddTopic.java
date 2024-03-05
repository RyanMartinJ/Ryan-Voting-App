package com.example.votingappproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.TextView;

public class AddTopic extends AppCompatActivity {

    EditText Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtopic);

        Add = (EditText)findViewById(R.id.NewVotingParameter);
    }
}
