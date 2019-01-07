import java.io.*;
import java.util.*;

public class Customer implements DataAccess {
    private int id;
    private String surName;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<String[]> customerArray= new ArrayList<String[]>();

    //Constructor with name,surname,phoneNumber and adress
    public Customer(int id, String name, String surName, String  phoneNumber, String  address) {
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Customer(){

    }


    //Implementing getter and setter methods.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String[]> getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(ArrayList<String[]> customerArray) {
        this.customerArray = customerArray;
    }



    //Customers are being read and written the customerArray.
    public void readText() {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("customer.txt")))) {
            customerArray.clear();
            while (sc.hasNextLine()) {
                String bilgiler = sc.nextLine().trim();
                customerArray.add(bilgiler.split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //If there is any changes in the customerArray, it is written the customer.txt
    public void writeText(){
        int sayac = 0;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("customer.txt")))){
            for(String[] list:customerArray){
                if(list[0].isEmpty()){
                    break;
                }
                String address = "";
                for(int i = 5 ; i<list.length;i++){
                    address += list[i] + " ";
                }
                if(sayac == 0)
                    writer.write(list[0] + " " + list[1] + " "+ list[2] + " " + list[3] + " Address: " + address);
                else
                    writer.write("\n"+list[0] + " " + list[1] + " "+ list[2] + " " + list[3] + " Address: " + address);
                sayac = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //If there is 'add' command in our input.txt, it is written customer.txt
    @Override
    public  void add(Object customer) {
        bufferedWriter("\n"+id + " " + name + " " + surName + " " + phoneNumber + " Address: " + address,"customer.txt",true);
        readText();
        customerArray.sort(Comparator.comparingInt(i -> Integer.parseInt(i[0])));
        writeText();
    }

    @Override
    public void update(int id, Object customer) {

    }

    //If there is 'remove' command in our input.txt, it is deleted customer.txt
    @Override
    public void delete(int id) {
        ArrayList<String[]> forRemove = new ArrayList<>();
        for(String[] list : customerArray){
            if(list[0].isEmpty()){
                break;
            }
            if(Integer.parseInt(list[0]) == id){
                forRemove.add(list);
            }
        }
        customerArray.removeAll(forRemove);
        customerArray.sort(Comparator.comparingInt(i -> Integer.parseInt(i[0])));
        writeText();
    }

    @Override
    public ArrayList<String[]> getAll() {
        return customerArray;
    }

    // This function basically  allows us to write a text to a file we want.
    private void bufferedWriter(String sentence,String pathname,Boolean append){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathname),append))){
            writer.write( sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}