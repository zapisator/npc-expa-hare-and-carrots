package org.example;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class GreedyHare implements Hare {
    private static final int VISIT_COUNT = 10;
    private static final int BAG_CAPACITY = 5;

    @Override
    public int[][] visit() {

        return IntStream.range(0, VISIT_COUNT)
                .mapToObj(visitNumber -> {
                    final int[] kitchenGarden = KitchenGardenFactory.kitchenGarden();
                    final int[] carrotsInBag = carrotsInBag(kitchenGarden);

                    System.out.println("kitchen garden         : " + Arrays.toString(kitchenGarden));
                    return carrotsInBag;
                })
                .toList()
                .toArray(new int[0][0]);
    }

    private int[] carrotsInBag(int[] carrots) {
        final int[] carrotsInBag = new int[BAG_CAPACITY];
        int residualCapacity = BAG_CAPACITY;

        for (int carrotSize = carrots.length; carrotSize > 0 && residualCapacity > 0; carrotSize--) {
            final int availableCarrotCount = carrots[carrotSize - 1];
            final int maxQuantityOfCarrots = maxQuantityOfCarrots(
                    residualCapacity, carrotSize, availableCarrotCount
            );

            if (maxQuantityOfCarrots > 0) {
                carrotsInBag[carrotSize - 1] = maxQuantityOfCarrots;
                residualCapacity -= maxQuantityOfCarrots * carrotSize;
            }
            System.out.println("maxQuantityOfCarrots = " + maxQuantityOfCarrots);
        }
        System.out.println("                         |1| 2| 3| 4| 5|\n"
                + "carrots in the hare bag: " + Arrays.toString(carrotsInBag)
        );
        return carrotsInBag;
    }

    private int maxQuantityOfCarrots(
            int residualCapacity,
            int carrotSize,
            int availableCarrotCount
    ) {
        System.out.printf(
                "| residualCapacity = %d | carrotSize = %d "
                        + "| availableCarrotCount = %d | ",
                residualCapacity, carrotSize, availableCarrotCount
        );
        if (availableCarrotCount == 0 || carrotSize > residualCapacity) {
            return 0;
        }
        return Math.min(residualCapacity / carrotSize, availableCarrotCount);
    }

}
