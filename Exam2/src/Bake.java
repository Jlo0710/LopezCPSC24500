import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bake {

    // Inventory of items that are in the bakery
    private Map<String, Integer> inventory;
    private List<String> line;

    public Bakery(){
        
        // Initialize inventory with each item
        inv = new HashMap<>();
        inv.put("croissant", 10);
        inv.put("muffin", 5);
        inv.put("baguette", 8);

        // Intializes the line of customers
        line = new ArrayList<>();
    }

    // Add a customer to the line
    public void addCust(String name){
        line.add(name);
    }

    // Processes the first customer's order and updates the inventory
    public void placeOrder(){
        if(line.isEmpty()){
            System.out.println("No Customers to serve today.");
            return;
        }

        String customer = line.remove(0); // Serves the first customer
        System.out.print(customer + " ordered: ");

        // Keeps track of the items fulfilled in the order
        boolean fulfilledOrder = false;
        for(Map.Entry<String, Integer> entry : inv.entrySet()){
            String item = entry.getKey();
            int quant = entry.getValue();

            if(quant > 0){
                inv.put(item,quant - 1); // Reduces the inventory for each item ordered
                System.out.print(item + " ");
                fulfilledOrder = true;
            }
        }

        if (!fulfilledOrder){
            System.out.println(customer + " could not be served due to all items being sold out.");
        }else{
            System.out.println();
        }
    }

    // Checks to see if the bakery is sold out of ALL items
    public boolean isSoldOut(){
        for(int quant : inv.values()){
            if(quant > 0){
                return false; // Items aren't sold out yet
            }
        }
        return true; // ALL items are officially sold out
    }

    // Display the summary of orders and sold-out items
    public void displaySummary(){
        System.out.println("\nSold-out Items: ");
        for(Map.Entry<String, Integer> entry : inv.entrySet()){
            if(entry.getValue() == 0){
                System.out.println("- " + entry.getKey());
            }
        }
    }

    // Main method that will run the bakery simulation
    public static void main(String[] args) throws Exception {
        Bake bakery = new Bake();

        // Add customers to the line
        bakery.addCust("John");
        bakery.addCust("Jesse");
        bakery.addCust("Michael");
        bakery.addCust("Madison");
        bakery.addCust("Adam");

        // processes the orders until the bakery is sold out
        while(!bakery.isSoldOut() && !bakery.line.isEmpty()){
            bakery.placeOrder();
        }

        // Displays the summary of orders and the sold out items
        bakery.displaySummary();
    }
}
