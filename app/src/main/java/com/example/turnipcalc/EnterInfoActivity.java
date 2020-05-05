package com.example.turnipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.Button;

public class EnterInfoActivity extends AppCompatActivity {

    CheckBox am;
    CheckBox pm;

    int pricePurchased, currentPrice;
    EditText purchasedInput;
    EditText currentInput;
    Button submitButton;
    private EditText currentSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        //calling the user input of editCurrent, which is the current turnip price
        currentSubmit = (EditText) findViewById(R.id.editCurrent);
        //changing the user input to a string
        final String currentString = currentSubmit.getText().toString();
        final String history[];
        //creating the array to store each user input in
        history = new String[12];

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
        purchasedInput = (EditText) findViewById(R.id.editPurchased);
        currentInput = (EditText) findViewById(R.id.editCurrent);
        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricePurchased = Integer.valueOf(purchasedInput.getText().toString());
                currentPrice = Integer.valueOf(currentInput.getText().toString());

                showToast(pricePurchased);
                showToast(currentPrice);

                //if the user inputs a value, then the array will loop through and find the next empty index, then store that value in the array.
                if (currentString.length() != 0 ) {
                    for (int i = 0; i <= history.length; i++) {
                        if (history[i].equals("")) {
                            history[i] = currentString;
                        }
                    }

                }
            }
        });


    }

    private void showToast(int inputText) {
        Toast.makeText(EnterInfoActivity.this, inputText, Toast.LENGTH_SHORT).show();
    }

}