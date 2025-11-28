package FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        Zoo zoo= new Zoo();
        Animal animal=zoo.getAnimal("CAT");
        animal.animalType();
        Animal animal1=zoo.getAnimal("DOG");
        animal1.animalType();
    }
}
