import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private ArrayList<String[]> orderArray= new ArrayList<String[]>();
    private ArrayList<String[]> totalCost = new ArrayList<>();

    public ArrayList<String[]> getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(ArrayList<String[]> totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<String[]> getOrderArray() {
        return orderArray;
    }

    public void setOrderArray(ArrayList<String[]> orderArray) {
        this.orderArray = orderArray;
    }

    //Orders are being read and written the orderArray.
    public void readText() {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("order.txt")))) {
            orderArray.clear();
            while (sc.hasNextLine()) {
                String bilgiler = sc.nextLine().trim();
                orderArray.add(bilgiler.split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This function basically allows us to write a text to a file we want.
    private void bufferedWriter(String sentence,String pathname,Boolean append){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathname),append))){
            writer.write( sentence);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
