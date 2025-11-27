package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class AddExpenseActivity extends AppCompatActivity {

    private static final int CUSTOM_CATEGORY_INDEX = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Button buttonSaveExpense = findViewById(R.id.button_saveExpense);
        buttonSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddExpenseActivity.this, "Визуальный переход на Главный экран", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Spinner spinnerCategory = findViewById(R.id.spinner_category);
        final TextInputLayout inputLayoutCustomDescription = findViewById(R.id.inputLayout_customDescription);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == CUSTOM_CATEGORY_INDEX) {
                    inputLayoutCustomDescription.setVisibility(View.VISIBLE);
                } else {
                    inputLayoutCustomDescription.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}