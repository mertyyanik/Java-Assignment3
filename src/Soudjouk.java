public class Soudjouk implements PizzaInterface {

    int cost = 3;
    String topping = "soudjouk ";

    public Soudjouk(){

    }
    // This constructor adds on to the strings and costs constantly
    public Soudjouk(PizzaInterface pizzaInterface){
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
