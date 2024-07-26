package org.example;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KitchenGardenFactory {
    private static final XoRoShiRo128PlusRandom RANDOMIZER = new XoRoShiRo128PlusRandom();

    public static int[] kitchenGarden() {
        final int[] kitchenGarden = new int[5];

        kitchenGarden[4] = RANDOMIZER.nextInt(0, 2);
        kitchenGarden[3] = RANDOMIZER.nextInt(0, 2);
        kitchenGarden[2] = RANDOMIZER.nextInt(0, 2);
        kitchenGarden[1] = RANDOMIZER.nextInt(0, 3);
        kitchenGarden[0] = RANDOMIZER.nextInt(0, 6);
        return kitchenGarden;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(KitchenGardenFactory.kitchenGarden()));
        }
    }
}
