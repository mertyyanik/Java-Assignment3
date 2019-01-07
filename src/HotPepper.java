public class HotPepper  implements PizzaInterface {

    int cost = 1;
    String topping = "hotpapper ";

    public HotPepper() {
    }
    // This constructor adds on to the strings and costs constantly
    public HotPepper(PizzaInterface pizzaInterface){
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
