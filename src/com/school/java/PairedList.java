package com.school.java;

public class PairedList<AnimalClass, Quantity> {

    // https://stackoverflow.com/a/4777636

    private AnimalClass animalClass;
    private Quantity quantity;

    public PairedList(AnimalClass animalClass, Quantity quantity) {
        this.animalClass=animalClass;
        this.quantity=quantity;
    }

    public AnimalClass getAnimalClass(){
        return animalClass;
    }
    public Quantity getQuantity(){
        return quantity;
    }

    public void setAnimalClass (AnimalClass animalClass) {
        this.animalClass=animalClass;
    }

    public void setQuantity (Quantity quantity) {
        this.quantity=quantity;
    }

}
