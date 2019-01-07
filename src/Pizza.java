public class Pizza  {

     int cost;
     String topping;

     public Pizza(int cost,String topping) {
          this.cost = cost;
          this.topping = topping + " ";
     }

     public void addTopping() {

     }

     public void addTopping(PizzaInterface pizzaInterface) {
          cost += pizzaInterface.cost();
          topping += pizzaInterface.printToppings();
     }

     public String printToppings(){
          return topping;
     }
     public int cost(){
        return cost;
     }
}
