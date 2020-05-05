package com.example.turnipcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonInfo = (Button) findViewById(R.id.infoButton);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInfoActivity();
            }
        });
    }
    private void goToInfoActivity() {
        Intent intent = new Intent(MainActivity.this, EnterInfoActivity.class);
        startActivity(intent);
    }
}