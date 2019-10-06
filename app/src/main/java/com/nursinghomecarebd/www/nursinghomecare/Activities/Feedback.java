package com.nursinghomecarebd.www.nursinghomecare.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nursinghomecarebd.www.nursinghomecare.R;

public class Feedback extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton, clearButton;
    private EditText nameEditText, massageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        sendButton = (Button) findViewById(R.id.sentButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        nameEditText = (EditText) findViewById(R.id.nameId);
        massageEditText = (EditText) findViewById(R.id.massageId);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

            String name = nameEditText.getText().toString();
            String massage = massageEditText.getText().toString();

            if (v.getId() == R.id.sentButton) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");


                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"md.deluar.hs@gmail.com"});


                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message: " + massage);
                startActivity(intent.createChooser(intent, "Feedback with"));


            } else if (v.getId() == R.id.clearButton) {

                nameEditText.setText("");
                massageEditText.setText("");

            }

        } catch (Exception e) {


            Toast.makeText(getApplicationContext(), "Exception:" + e, Toast.LENGTH_SHORT).show();

        }

    }
}