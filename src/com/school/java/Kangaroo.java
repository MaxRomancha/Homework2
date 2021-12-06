package com.school.java;

import java.util.EnumSet;

public class Kangaroo extends Animal {

    public static final Habitat habitat = Habitat.EARTH;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.PLANTS);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 85;
    public static final int requiredLivingSpace = 300;

}
