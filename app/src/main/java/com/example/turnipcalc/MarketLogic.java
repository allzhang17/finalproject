package com.example.turnipcalc;

public class MarketLogic {
    public int[] history = new int[12];
    public int value;

    public boolean isDecreasing(int[] history, int value) {
        if ()
    }

    public boolean isSpike(int[] history) {
        int count = 0;
        for (int i = 1; i < history.length; i++) {
            if (history[i - 1] > history[i] && history[i] > history[i + 1]) {
                for (int j = i + 1; j < history.length; j++) {
                    if (count == 3) {
                        return true;
                    }
                    if (history[j + 1] > history[j]) {
                        count++;
                    }
                }
            }
        }
        return false;
    }
}
