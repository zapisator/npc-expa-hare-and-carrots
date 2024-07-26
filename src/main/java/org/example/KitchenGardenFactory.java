package org.example;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class KitchenGarden {
    private final List<AbstractMap.SimpleEntry<Integer, String>> carrots;

    public static KitchenGarden create() {
        final Random randomizer = new Random();

        IntStream.rangeClosed(1, 5)
                .map(carrotSize -> new AbstractMap.SimpleEntry<>(carrotSize, randomizer.nextInt(0, 5)))


    }
}
