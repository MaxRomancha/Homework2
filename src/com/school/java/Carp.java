package com.school.java;

import java.util.EnumSet;

public class Carp extends Animal {

    public static final Habitat habitat = Habitat.WATER;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.ALGAE,Food.INSECTS);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 4;
    public static final int requiredLivingSpace = 8;

}
