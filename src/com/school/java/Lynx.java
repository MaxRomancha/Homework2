package com.school.java;

import java.util.EnumSet;

public class Lynx extends Animal {

    public static final Habitat habitat = Habitat.EARTH;
    public static final EnumSet<Food> preferredFood = EnumSet.of(Food.MEAT);
    public static final FeedingBehaviour feedingBehaviour = determineFeedingBehaviour(preferredFood);
    public static final int maxWeight = 30;
    public static final int requiredLivingSpace = 200;

}
