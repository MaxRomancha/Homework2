package com.school.java;

import java.util.EnumSet;

public class Racoon extends Animal {

    public static final Habitat habitat = Habitat.EARTH;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.MEAT);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 9;
    public static final int requiredLivingSpace = 50;

}
