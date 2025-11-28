package FactoryDesignPattern;

public class Zoo {

    Animal getAnimal(String input){
        switch (input){
            case "DOG":
                return new Dog();
            case "CAT":
                return  new Cat();
            default:
                return null;
        }

    }
}
