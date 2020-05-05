package com.example.turnipcalc;
import java.util.List;
import java.util.ArrayList;

public class MarketLogic {

    public boolean isDecreasing(int[] input) {
        int count = 0;
        for (int i = 1; i < input.length - 1; i++) {
            if (count == 6) {
                return true;
            }
            if (input[i - 1] > input[1] && input[i] > input[i + 1]) {
                count++;
            }
        }
        return false;

    }

    public boolean isSpike(int[] input) {
        int count = 0;
        for (int i = 1; i < input.length - 1; i++) {
            if (input[i - 1] > input[i] && input[i] > input[i + 1]) {
                for (int j = i + 1; j < input.length - 1; j++) {
                    if (count == 2) {
                        return true;
                    }
                    if (input[j + 1] > input[j] && input[j] > input[j - 1]) {
                        count++;
                    }
                }
            }
        }
        return false;
    }

    public boolean largeSpike(int currentprice, int[] input) {
        boolean a = isSpike(input);
        if (a) {
            if (currentprice > 200) {
                return true;
            }
        }
        return false;
    }

    public boolean smallSpike(int currentprice, int[] input) {
        boolean a = largeSpike(currentprice, input);
        if (!a) {
            int count = 0;
            for (int i = 1; i < input.length; i++) {
                if (count == 3) {
                    return true;
                }
                if (input[i - 1] < input[i] && input[i] < input[i + 1]) {
                    count++;
                }
            }
        }
        return false;
    }

    public boolean isRandom(int currentprice, int[] input) {
        boolean a = isDecreasing(input);
        boolean b = largeSpike(currentprice, input);
        boolean c = smallSpike(currentprice, input);
        if (!a && !b && !c) {
            return true;
        }
        return false;
    }

}
