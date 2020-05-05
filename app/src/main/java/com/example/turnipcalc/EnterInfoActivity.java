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
import android.widget.TextView;

public class EnterInfoActivity extends AppCompatActivity {



    float result_num;
    int num1, num2;
    int pricePurchased, currentPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);


        final TextView result;
        final EditText purchasedInput;
        final EditText currentInput;
        Button submitButton;

        final CheckBox am;
        final CheckBox pm;

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
        purchasedInput = findViewById(R.id.editPurchased);
        currentInput = findViewById(R.id.editCurrent);
        submitButton = findViewById(R.id.submit);
        result = findViewById(R.id.result);

        final String text1 = "Your price curve is decreasing";
        final String text2 = "Your price curve is increasing";


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pricePurchased = Integer.valueOf(purchasedInput.getText().toString());
                currentPrice = Integer.valueOf(currentInput.getText().toString());
                if (pricePurchased > currentPrice && am.isChecked()) {
                    result.setText(text1);
                } else if (currentPrice > pricePurchased && pm.isChecked()) {
                    result.setText(text2);
                }

            }
        });


    }
    
}