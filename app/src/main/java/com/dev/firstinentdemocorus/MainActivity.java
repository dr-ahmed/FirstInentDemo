package com.dev.firstinentdemocorus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstNumberEdt, secondNumberEdt;
    private Button calculateBtn;
    private TextView sumTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
        getDataFromSecondActivityIntent();
    }

    private void initViews() {
        firstNumberEdt = findViewById(R.id.first_number_edt);
        secondNumberEdt = findViewById(R.id.second_number_edt);
        calculateBtn = findViewById(R.id.calculate_btn);
        sumTxt = findViewById(R.id.sum_txt);
    }

    private void setListeners() {
        calculateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText[] editTexts = {firstNumberEdt, secondNumberEdt};
        for (EditText editText : editTexts)
            if (isEmptyEdittext(editText)) {
                dontAllowEmptyEdittext(editText);
                return;
            }

        launchSecondActivity();
    }

    private boolean isEmptyEdittext(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    private void dontAllowEmptyEdittext(EditText editText) {
        editText.requestFocus();
        editText.setError("Champ obligatoire!");
    }

    private void launchSecondActivity() {
        Intent intent = new Intent(getBaseContext(), SecondActivity.class);
        intent.putExtra("first_number", firstNumberEdt.getText().toString());
        intent.putExtra("second_number", secondNumberEdt.getText().toString());
        startActivity(intent);
    }

    private void getDataFromSecondActivityIntent() {
        if (getIntent().hasExtra("somme"))
            sumTxt.setText("Somme = " + Integer.valueOf(getIntent().getIntExtra("somme", 0)));
    }
}
