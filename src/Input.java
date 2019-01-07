import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Input {
    private String inputArray[][] = new String[100][100];
    private int sayac = 0;

    //Input are being read and written the inputArray.
    public void readText(String args) {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(args)))) {
            while (sc.hasNextLine()) {
                String bilgiler = sc.nextLine().trim();
                inputArray[sayac] = bilgiler.split(" ");
                sayac++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String[][] getInputArray() {
        return inputArray;
    }

    public void setInputArray(String[][] inputArray) {
        this.inputArray = inputArray;
    }



    public void command() {
        Order permaorder = new Order();
        //All orders are being taken in turn.
        for(String[] commands : inputArray){
            if (commands[0] == null || commands[0].isEmpty()) {
                break;
            }
            // If order is 'AddCustomer'
            if(commands[0].equals("AddCustomer")){
                Boolean check = false;
                String address = "";
                for(int i = 5 ; i<commands.length;i++){
                    address += commands[i] + " ";
                }
                Customer customer = new Customer(Integer.parseInt(commands[1]),commands[2],commands[3],commands[4],address);
                customer.readText();
                for(String[] list : customer.getCustomerArray()){
                    if(list[0].equals(commands[1])){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    customer.add(commands[1]);
                    bufferedWriter("Customer " + commands[1] + " " + commands[2] + " added\n","output.txt",true);
                }
            }
            //If order is 'RemoveCustomer'
            else if(commands[0].equals("RemoveCustomer")){
                Customer customer = new Customer();
                customer.readText();
                for(String[] list : customer.getCustomerArray()){
                    if(list[0].equals(commands[1])){
                        bufferedWriter("Customer " + list[0] + " " + list[1] + " removed\n","output.txt",true);
                    }
                }
                customer.delete(Integer.parseInt(commands[1]));

            }
            //If order is 'ListCustomer'
            else if(commands[0].equals("List") && commands[1].equals("Customers")){
                Customer customer = new Customer();
                customer.readText();
                customer.getCustomerArray().sort(Comparator.comparing(arrayCustomer -> arrayCustomer[1]));
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt"),true))){
                    writer.write("Custormer List:\n");
                    for(String[] list : customer.getAll()){
                        writer.write(list[0] + " " + list[1] + " " + list[2] + " " + list[3] + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //If order is 'CreateOrder'
            else if(commands[0].equals("CreateOrder")){
                Order order = new Order();
                order.readText();
                bufferedWriter( "\nOrder: " + commands[1] + " " + commands[2],"order.txt",true);
                bufferedWriter("Order " + commands[1] + " created\n","output.txt",true);
                order.readText();
            }
            //If order is 'AddPizza'
            else if(commands[0].equals("AddPizza")){
                //If we want to add a AmericanPan Pizza
                if(commands[2].equals("AmericanPan")){
                    ArrayList<String> temporaryArray = new ArrayList<>();
                    bufferedWriter("AmericanPan pizza added to order " + commands[1] +"\n","output.txt",true);
                    for(int i = 3 ; i < commands.length ; i++){
                        temporaryArray.add(commands[i]);
                    }
                    Pizza pizza = new Pizza(5,"AmericanPan");
                    //This if-else block is basically find all toppings and adding on the price of the pizza.
                    if(temporaryArray.size() == 2) {
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(1)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(temporaryArray.size() == 3){
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(1)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(2)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(temporaryArray.size() == 1){
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    bufferedWriter("\n"+pizza.printToppings(),"order.txt",true);
                    String[] gecici = new String[100];
                    gecici[0] = commands[1];
                    gecici[1] = pizza.printToppings();
                    gecici[2] = String.valueOf(pizza.cost);
                    permaorder.getTotalCost().add(gecici);
                }
                //If we want to add a Neapolitan Pizza
                else if(commands[2].equals("Neapolitan")){
                    ArrayList<String> temporaryArray = new ArrayList<>();
                    bufferedWriter("Neapolitan pizza added to order " + commands[1] +"\n","output.txt",true);
                    for(int i = 3 ; i < commands.length ; i++){
                        temporaryArray.add(commands[i]);
                    }
                    Pizza pizza = new Pizza(10,"Neapolitan");
                    //This if-else block is basically find all toppings and adding on the price of the pizza.
                    if(temporaryArray.size() == 2) {
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(1)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(temporaryArray.size() == 3){
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(1)).newInstance());
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(2)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(temporaryArray.size() == 1){
                        try {
                            pizza.addTopping((PizzaInterface) Class.forName(temporaryArray.get(0)).newInstance());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    bufferedWriter("\n"+pizza.printToppings(),"order.txt",true);
                    String[] gecici = new String[100];
                    gecici[0] = commands[1];
                    gecici[1] = pizza.printToppings();
                    gecici[2] = String.valueOf(pizza.cost);
                    permaorder.getTotalCost().add(gecici);
                }
            }
            //If we want to add a Drink
            else if(commands[0].equals("AddDrink")){
                bufferedWriter("Drink added to order " + commands[1] +"\n","output.txt",true);
                bufferedWriter("\nSoftdrink","order.txt",true);
                String[] gecici = new String[100];
                gecici[0] = commands[1];
                gecici[1] = "Softdrink";
                gecici[2] = " 2";
                permaorder.getTotalCost().add(gecici);
            }
            //If order is 'PayCheck'
            else if(commands[0].equals("PayCheck")){
                int temporaryCost = 0;
                bufferedWriter("PayCheck for order " + commands[1] + "\n","output.txt",true);
                for(String[] list : permaorder.getTotalCost()){
                    if(list[0].equals(commands[1])){
                        bufferedWriter("\t"+list[1] + list[2]+ "$" + "\n","output.txt",true);
                        temporaryCost += Integer.parseInt(list[2].trim());
                    }
                }
                bufferedWriter("\tTotal: " + temporaryCost + "$" + "\n","output.txt",true);
            }
        }
    }
    // This function basically  allows us to write a text to a file we want.
    private void bufferedWriter(String sentence,String pathname,Boolean append){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathname),append))){
            writer.write(sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}