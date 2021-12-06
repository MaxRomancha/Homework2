package com.school.java;

public enum FeedingBehaviour {
    CARNIVORE(false, true),
    HERBIVORE(true, false),
    OMNIVORE(true, true),
    OTHER(false, false);

    public final boolean eatsPlants;
    public final boolean eatsMeat;

    private FeedingBehaviour(boolean eatsPlants, boolean eatsMeat) {
        this.eatsPlants = eatsPlants;
        this.eatsMeat = eatsMeat;
    }


}
