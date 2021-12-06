package com.school.java;

import java.util.EnumSet;

public class Eagle extends Animal {

    public static final Habitat habitat = Habitat.AIR;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.MEAT);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 7;
    public static final int requiredLivingSpace = 100;

}
