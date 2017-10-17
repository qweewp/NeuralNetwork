package com.epam.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
