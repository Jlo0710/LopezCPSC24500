import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Declare variables
        String name;
        String coffeeType;
        String sugar;
        String sugarChoice;

        // Scanner method
        Scanner scan = new Scanner(System.in);

        // Print statement asking for the users name
        System.out.println("Hello and Welcome! Can I get your name please?");
        name = scan.nextLine();

        // Asks the user what type of coffee they want
        System.out.println("What type of Coffee would you like? (Espresso, Latte, Americano): ");
        coffeeType = scan.nextLine();

        // Asks the user if they want sugar
        System.out.println("Would you like to add sugar?(Yes/No)");
        sugar = scan.nextLine();

        if(sugar.equals("Yes")){
            sugarChoice = "with sugar";
        }else{
            sugarChoice = "without sugar";
        }

        // Print out the receipt
        System.out.println("One " + coffeeType + " " + sugarChoice + " coming right up, " + name + "!");
    }
}
