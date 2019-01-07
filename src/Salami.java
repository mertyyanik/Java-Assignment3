public class Salami  implements PizzaInterface {

    int cost = 3;

    String topping = "salami ";

    public Salami() {
    }
    // This constructor adds on to the strings and costs constantly
    public Salami(PizzaInterface pizzaInterface){
        cost += pizzaInterface.cost();
        topping += pizzaInterface.printToppings();
    }

    @Override
    public String printToppings() {
        return topping;
    }

    @Override
    public int cost() {
        return cost;
    }
}
