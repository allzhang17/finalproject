package com.example.turnipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.Toast;

public class EnterInfoActivity extends AppCompatActivity {

    CheckBox am;
    CheckBox pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

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

    }
}
