public class Onion implements PizzaInterface {

    int cost = 2;
    String topping = "onion ";
    public Onion() {
    }
    // This constructor adds on to the strings and costs constantly
    public Onion(PizzaInterface pizzaInterface){
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
