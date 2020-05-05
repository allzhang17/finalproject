package com.example.turnipcalc;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MarketLogic extends EnterInfoActivity {
    private EditText currentSubmit;
    private Spinner daySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logic_market);
        currentSubmit = findViewById(R.id.editCurrent);
        daySpinner = findViewById(R.id.daySpinner)
        String inputNumber = currentSubmit.getText().toString();
        int finalNumber = Integer.parseInt(inputNumber);
        final int[] history;
        final int[] AM;
        final int[] PM;
        AM = new int[6];
        PM = new int[6];
        history = new int[12];
        int day = daySpinner.getSelectedItemPosition();
        if (finalNumber > 0) {
            for (int i = 0; i < history.length - 1; i++) {
                if (history[i] == 0) {
                    history[i] = finalNumber;
                }
            }
        }


        public void isDecreasing(history) {
            int count = 0;
            for (int i = 1; i < history.length - 1; i++) {
                if (history[i - 1] > history[1] && history[i] > history[i + 1]) {
                    count++;
                    if (count == 6) {
                        System.out.println("Your price curve is decreasing");
                        System.out.println("Sell your turnips now");
                    }
                }
            }
        }

        public void isSpike(finalNumber, history) {
            int count = 0;
            for (int i = 1; i < history.length - 1; i++) {
                if (history[i - 1] > history[i] && history[i] > history[i + 1]) {
                    count++;
                    if (finalNumber > 200 && count == 2) {
                        System.out.println("Your price curve is a large spike");
                        System.out.println("Sell your turnips now");
                    } else if (finalNumber > 100 && count == 3) {
                        System.out.println("Your price curve is a small spike");
                        System.out.println("Sell your turnips now");
                    }
                }
            }
        }
    }
}





