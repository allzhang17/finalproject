package com.example.turnipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class EnterInfoActivity extends AppCompatActivity {

    TextView result;
    EditText purchased;
    EditText current;
    String stringPurchased = purchased.getText().toString();
    String stringCurrent = current.getText().toString();

    CheckBox am;
    CheckBox pm;

    int pricePurchased, currentPrice;

    Button submitButton;
    private EditText currentSubmit;
    String result_num;
    int numCurrent, numPurchased;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);
        result = (TextView) findViewById(R.id.result);
        purchased = findViewById(R.id.editPurchased);
        current = findViewById(R.id.editCurrent);



        Spinner daySpinner = findViewById(R.id.daySpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(EnterInfoActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.select));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(myAdapter);

        am = findViewById(R.id.amCheck);
        pm = findViewById(R.id.pmCheck);

        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (am.isChecked()) {
                    Toast.makeText(EnterInfoActivity.this, "8 a.m. to 11:59 a.m.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pm.isChecked()) {
                    Toast.makeText(EnterInfoActivity.this, "12 p.m. to 10 p.m.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast(pricePurchased);
                showToast(currentPrice);

                numCurrent = Integer.parseInt(stringCurrent);
                numPurchased = Integer.parseInt(stringPurchased);
                if (numCurrent > numPurchased) {
                    result_num = "your price curve is decreasing, you should sell now";
                    result.setText(result_num);
                } else if (numPurchased > numCurrent) {
                    result_num = "your price curve is increasing, you should wait to sell";
                    result.setText(result_num);
                }

            }
        });
    }
    private void showToast(int inputText) {
        Toast.makeText(EnterInfoActivity.this, inputText, Toast.LENGTH_SHORT).show();
    }

}