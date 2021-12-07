package com.school.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println("Task 1. Returning properties of instances of animals of various classes.");
        promptEnterKey();
        List<PairedList<Animal, Integer>> pairedListForTask1 = new ArrayList<>();
        fillPairedListForTask1(pairedListForTask1);
        ArrayList<Animal> listOfCreatedAnimals = createAnimalsForTask1(pairedListForTask1);

        task1(listOfCreatedAnimals);
        promptEnterKey();

        System.out.println("Task 2. Calculation based on the values of the fields of the classes.");
        List<PairedList<Animal, Integer>> pairedListForTask2 = new ArrayList<>();
        fillPairedListForTask2(pairedListForTask2);

        task2(pairedListForTask2, "requiredLivingSpace");
        promptEnterKey();

        System.out.println("Optional task. Calculation based on the values of the fields of the filtered classes.");
        List<PairedList<Animal, Integer>> listForOptionalTask = new ArrayList<>();

        for (Habitat i : Habitat.values()) {
            System.out.println(i);
            listForOptionalTask = listFilterForOptionalTask(pairedListForTask2, i);
            task2(listForOptionalTask, "maxWeight");
            promptEnterKey();
        }

        System.out.println("The end of the program reached.");
        promptEnterKey();

    }

    public static void fillPairedListForTask1(List<PairedList<Animal, Integer>> pairedListToFill) {
        //TODO creates duplicating instances if quantity>1
        pairedListToFill.add(new PairedList<>(new Lynx(), 1));
        pairedListToFill.add(new PairedList<>(new Racoon(), 1));
        pairedListToFill.add(new PairedList<>(new Kangaroo(), 1));
        pairedListToFill.add(new PairedList<>(new Eagle(), 1));
        pairedListToFill.add(new PairedList<>(new Ostrich(), 1));
        pairedListToFill.add(new PairedList<>(new Carp(), 1));
        pairedListToFill.add(new PairedList<>(new SeaRoach(), 1));
    }

    public static ArrayList<Animal> createAnimalsForTask1(List<PairedList<Animal, Integer>> pairedListForTask1) {
        ArrayList<Animal> listOfCreatedAnimals = new ArrayList<>();
        for (PairedList i : pairedListForTask1) {
            for (int j = 1; (j <= (int) i.getQuantity()); j++) {
                listOfCreatedAnimals.add((Animal) i.getAnimalClass());
            }
        }

        return listOfCreatedAnimals;
    }

    public static void task1(ArrayList<Animal> listAnimalInstances) throws NoSuchFieldException, IllegalAccessException {
        for (Animal currentAnimal : listAnimalInstances) {
            System.out.print(currentAnimal.printClassProperties());
            System.out.println(currentAnimal.feedAnimal(Food.GRASS));
            System.out.println(currentAnimal.feedAnimal(Food.MEAT));
            System.out.println();
        }
    }

    public static void fillPairedListForTask2(List<PairedList<Animal, Integer>> pairedListToFill) {
        pairedListToFill.add(new PairedList<>(new Lynx(), 5));
        pairedListToFill.add(new PairedList<>(new Racoon(), 4));
        pairedListToFill.add(new PairedList<>(new Kangaroo(), 2));
        pairedListToFill.add(new PairedList<>(new Eagle(), 7));
        pairedListToFill.add(new PairedList<>(new Ostrich(), 3));
        pairedListToFill.add(new PairedList<>(new Carp(), 15));
        pairedListToFill.add(new PairedList<>(new SeaRoach(), 7));
    }

    public static int task2(List<PairedList<Animal, Integer>> pairedListToProcess, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        int task2Result = 0;

        for (PairedList i : pairedListToProcess) {
            task2Result += (Integer) i.getQuantity() *
                    (Integer) i.getAnimalClass().getClass().getField(fieldName).get(i);
        }

        printPairedListToConsole(pairedListToProcess, fieldName);
        System.out.printf("Total %s: %s%n%n", fieldName, task2Result);

        return task2Result;
    }

    public static void printPairedListToConsole(List<PairedList<Animal, Integer>> pairedListToPrint, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        for (PairedList i : pairedListToPrint) {
            System.out.printf("%s x %s (%s each)%n",
                    i.getAnimalClass().getClass().getSimpleName(),
                    i.getQuantity(),
                    i.getAnimalClass().getClass().getField(fieldName).get(i));
        }
    }

    public static List<PairedList<Animal, Integer>> listFilterForOptionalTask(List<PairedList<Animal, Integer>> listToFilter,
                                                                              Habitat requiredHabitat)
            throws NoSuchFieldException, IllegalAccessException {
        List<PairedList<Animal, Integer>> filteredList = new ArrayList<>();

        for (PairedList i : listToFilter) {
            Object currentFeedingBehaviour = i.getAnimalClass().getClass().getField("habitat").get(i);

            if (currentFeedingBehaviour == requiredHabitat) {
                filteredList.add(i);
            }
        }

        return filteredList;
    }

    public static void promptEnterKey() {
        //prompting the user to press ENTER.
        System.out.print("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        System.out.println();
    }

}
