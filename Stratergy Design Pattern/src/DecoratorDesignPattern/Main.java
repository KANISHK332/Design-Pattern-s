package DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
       BasePizza pizza= new Margarita();
        System.out.println(pizza.cost());

        BasePizza MargaritapizzawithToppings= new Toppings(new Margarita());
        System.out.println(MargaritapizzawithToppings.cost());

        BasePizza extraCheeseWithTopping= new ExtraCheese(new Toppings(new FarmHouse()));
        System.out.println(extraCheeseWithTopping.cost());
    }

}
