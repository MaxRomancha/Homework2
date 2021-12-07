package com.school.java;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    private final String name = pickRandomNameFromFile();
    private final LocalDate birthDate = pickRandomAnimalBirthDate();

    public String pickRandomNameFromFile() {
        int randomLineNumber = ThreadLocalRandom.current().nextInt(100);
        String randomName;
        try {
            randomName = Files.readAllLines(Paths.get("txt/names.txt")).get(randomLineNumber);
        } catch (Exception e) {
            randomName = "randomName" + randomLineNumber;
        }
        return randomName;
    }

    public LocalDate pickRandomAnimalBirthDate() {
        int randomAgeInDays = ThreadLocalRandom.current().nextInt(2000);
        return LocalDate.now().minusDays(randomAgeInDays);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public static FeedingBehaviour determineFeedingBehaviour(EnumSet<Food> foodList) {
        FeedingBehaviour feedingBehaviour = FeedingBehaviour.OTHER;

        boolean consumesPlants = false;
        for (Food i : foodList) {
            if (i.getIsPlant()) {
                consumesPlants = true;
                break;
            }
        }

        boolean consumesMeat = false;
        for (Food i : foodList) {
            if (i.getIsMeat()) {
                consumesMeat = true;
                break;
            }
        }

        if ((consumesPlants) && (consumesMeat)) {
            feedingBehaviour = FeedingBehaviour.OMNIVORE;
        } else if (consumesPlants) {
            feedingBehaviour = FeedingBehaviour.HERBIVORE;
        } else if (consumesMeat) {
            feedingBehaviour = FeedingBehaviour.CARNIVORE;
        }
        return feedingBehaviour;
    }

    public String printClassProperties() {
        // https://stackoverflow.com/a/1526843
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getSimpleName());
        result.append(" ").append(this.getName()).append(":").append(newLine);
        //result.append("{").append(newLine);

        result.append("  class: ").append(this.getClass().getSimpleName()).append(newLine);
        result.append("  name: ").append(this.getName()).append(newLine);
        result.append("  birthDate: ").append(this.getBirthDate()).append(newLine);

        Field[] fields = this.getClass().getFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        //result.append("}").append(newLine);

        return result.toString();

    }

    public String feedAnimal(Food food, FeedingBehaviour feedingBehaviour) {
        // method is not used, left here for any case

        String reactionToFood = "I will not eat " + food;
        if ((food.isPlant) && (feedingBehaviour.eatsPlants) || ((food.isMeat) && (feedingBehaviour.eatsMeat))) {
            reactionToFood = "I will eat " + food;
        }
        return reactionToFood;
    }


    public String feedAnimal(Food food) throws NoSuchFieldException, IllegalAccessException {
        String reactionToFood = "  I will not eat " + food;

        EnumSet preferredFood = (EnumSet) this.getClass().getField("preferredFood").get(food);
        if (preferredFood.contains(food)) {
            reactionToFood = "  I will eat " + food + " (this is exactly what I eat!)";
            return reactionToFood;
        }

        try {
            Field feedingBehaviour = this.getClass().getField("feedingBehaviour");

            //TODO I failed to access here the fields [eatsPlants]/[eatsMeat] from [FeedingBehaviour]
            Object obj = feedingBehaviour.get(new Object());

            if ((food.isPlant) && ((obj == FeedingBehaviour.HERBIVORE) || (obj == FeedingBehaviour.OMNIVORE))
                    || ((food.isMeat) && ((obj == FeedingBehaviour.CARNIVORE) || (obj == FeedingBehaviour.OMNIVORE)))) {
                reactionToFood = "  I will eat " + food;
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return reactionToFood;
    }

}
