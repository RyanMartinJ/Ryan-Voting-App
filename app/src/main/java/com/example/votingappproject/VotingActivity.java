package com.example.votingappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.content.DialogInterface;
import android.widget.LinearLayout;

public class VotingActivity extends AppCompatActivity {

        TextView Votes1, Votes2, Votes3, Votes4;
        Button Button1, Button2, Button3, Button4, AddTopicBtn;
        int count1, count2, count3, count4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        Votes1 = (TextView) findViewById(R.id.VoteText1);
        Votes2 = (TextView) findViewById(R.id.VoteText2);
        Votes3 = (TextView) findViewById(R.id.VoteText3);
        Votes4 = (TextView) findViewById(R.id.VoteText4);

        Button1 = (Button) findViewById(R.id.VoteButton1);
        Button2 = (Button) findViewById(R.id.VoteButton2);
        Button3 = (Button) findViewById(R.id.VoteButton3);
        Button4 = (Button) findViewById(R.id.VoteButton4);

        AddTopicBtn = findViewById(R.id.btnDisplay);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                Votes1.setText(String.valueOf(count1));
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                Votes2.setText(String.valueOf(count2));
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count3++;
                Votes3.setText(String.valueOf(count3));
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count4++;
                Votes4.setText(String.valueOf(count4));
            }
        });

//        AddTopicBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Start the VotingActivity
//                Intent intent = new Intent(VotingActivity.this, AddTopic.class);
//                startActivity(intent);
//            }
//        });

        AddTopicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtain the LayoutInflater
                LayoutInflater inflater = LayoutInflater.from(VotingActivity.this);

                // Inflate the custom layout for the AlertDialog
                View dialogView = inflater.inflate(R.layout.popup_add_topic, null);

                // Now you can use dialogView to find the EditText or any other views in your custom layout
                final EditText input = (EditText) dialogView.findViewById(R.id.editTextNewOption);

                AlertDialog.Builder builder = new AlertDialog.Builder(VotingActivity.this);
                builder.setView(dialogView)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String newOption = input.getText().toString();
                                // Handle the new option here
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
    }

    public void addNewVotingOption(String optionName) {
        LinearLayout optionsLayout = findViewById(R.id.optionsLayout); // Assuming you have this LinearLayout in your XML

        TextView newOptionView = new TextView(VotingActivity.this);
        newOptionView.setText(optionName);
        // You might want to style this TextView or add buttons for voting dynamically as well
        // Consider storing vote counts in a more dynamic structure like a Map if you haven't

        optionsLayout.addView(newOptionView);
        // Here, you would also need to handle the logic for voting on this new option
    }
}