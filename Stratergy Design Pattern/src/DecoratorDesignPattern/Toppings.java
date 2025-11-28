package DecoratorDesignPattern;

public class Toppings implements BasePizza{
   BasePizza pizza;
   Toppings(BasePizza pizza){
      this.pizza=pizza;
   }

   @Override
   public int cost() {
      return pizza.cost()+15;
   }
}
