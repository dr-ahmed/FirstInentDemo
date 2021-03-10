package com.dev.firstinentdemocorus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTxt;
    private Button goBackBtn;
    private String firstNb, secondNb;
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        setListeners();
        prepareDataFromMainActivityIntent();
        setResultTxt();
    }

    private void prepareDataFromMainActivityIntent() {
        firstNb = getIntent().getStringExtra("first_number");
        secondNb = getIntent().getStringExtra("second_number");
        sum = Integer.parseInt(firstNb) + Integer.parseInt(secondNb);
    }

    private void setResultTxt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstNb)
                .append("+")
                .append(secondNb)
                .append("=")
                .append(sum);
        resultTxt.setText(stringBuilder.toString());
    }

    private void setListeners() {
        goBackBtn.setOnClickListener(this);
    }

    private void initViews() {
        resultTxt = findViewById(R.id.result_txt);
        goBackBtn = findViewById(R.id.go_back_btn);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("somme", sum);
        startActivity(intent);

    }
}
