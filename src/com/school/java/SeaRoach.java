package com.school.java;

import java.util.EnumSet;

public class SeaRoach extends Animal {

    public static final Habitat habitat = Habitat.WATER;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.SHELLFISH,Food.CRUSTACEANS);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 2;
    public static final int requiredLivingSpace = 5;

}
