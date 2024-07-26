package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Hare hare = new GreedyHare();

        for (int i = 0; i < 100; i++) {
            final int[][] visit = hare.visit();

            System.out.println("visits of one day are: \n"
                    + "["
                    + "|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|=="
                    + "|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|=="
                    + "|1| 2| 3| 4| 5|==|1| 2| 3| 4| 5|"
                    + "]"
                    + "\n"
                    + Arrays.deepToString(visit)
                    + "\n");
        }
    }
}