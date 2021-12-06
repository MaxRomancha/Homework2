package com.school.java;

public enum Food {
    MEAT("meat in general", false, true),
    PLANTS("plants in general", true, false),
    ALGAE("algae", true, false),
    INSECTS("insects", false, true),
    SHELLFISH("shellfish", false, true),
    CRUSTACEANS("crustaceans", false, true),
    GRASS("grass", true, false),
    //ROCKS("rocks and boulders", false, false),
    //SALAD_OLIVIER("Olivier salad", true, true),
    ;

    public final String foodDescription;
    public final boolean isPlant;
    public final boolean isMeat;

    Food(String foodDescription, boolean isPlant, boolean isMeat) {
        this.foodDescription = foodDescription;
        this.isPlant = isPlant;
        this.isMeat = isMeat;
    }

    public boolean getIsPlant() {
        return isPlant;
    }

    public boolean getIsMeat() {
        return isMeat;
    }

}
