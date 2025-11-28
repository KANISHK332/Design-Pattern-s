package DecoratorDesignPattern;

public class ExtraCheese extends Toppings{
    ExtraCheese(BasePizza pizza){
        super(pizza);
    }

    public int cost(){
        return pizza.cost()+10;
    }
}
