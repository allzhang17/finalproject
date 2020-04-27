package com.example.turnipcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enterInfo = findViewById(R.id.infoButton);
        enterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInfoActivity();
            }
        });
    }
    private void goToInfoActivity() {
        Intent intent = new Intent(this, EnterInfoActivity.class);
        startActivity(intent);
    }
}
