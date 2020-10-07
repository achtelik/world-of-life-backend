package it.achtelik.worldoflife.utils;

import java.util.Random;

public class HexColorUtils {
    private final Random random;

    public HexColorUtils(Random random) {
        this.random = random;
    }

    public String randomHexColor() {
        // create a big random number - maximum is ffffff (hex) = 16777215 (dez)
        int nextInt = random.nextInt(0xffffff + 1);
        // format it as hexadecimal string (with hashtag and leading zeros)
        return String.format("#%06x", nextInt);
    }
}
