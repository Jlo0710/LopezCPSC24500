package WebSimulator.src;
import java.util.*;

class FluidSimulator {
    // Initialize variables
    private String consistency;
    private String elasticity;
    private String strength;
    private String durability;
    private String specialProperty;
    private double viscocity;
    private double tensileStrength;

    // Constructor to initialize final web fluid properties
    public FluidSimulator(String consistency, String elasticity, String strength, String durability, String specialProperty){
        this.consistency = consistency;
        this.elasticity = elasticity;
        this.strength = strength;
        this.durability = durability;
        this.specialProperty = specialProperty; 
        this.viscocity = viscocity;
        this.tensileStrength = tensileStrength;
    }

    // Class that will log the web fluid history 
class FluidLogger{
    private List<String> logs = new ArrayList<>();

    // Method to print the logged creation process
    public void log(String message){
        logs.add(message);
    }

    // Method to print the logged creation history
    public void printLogs(){
        System.out.println("\n--- Web Fluid History ---");
        for(String log : logs){
            System.out.println(log);
        }
    }
}

 // Class to simulate the web fluid creation process (WF = web fluid)
class WFSimulator {
    private Scanner scan;
    private FluidLogger logger;

    // Constructor to intialize scanner and logger
    public WFSimulator(){
        scan = new Scanner(System.in);
        logger = new FluidLogger();
    }

    public void simulation(){
        System.out.println("Welcome to Spider-Man's Web Fluid Simulator!");
        System.out.println("In this simulator, you will be creating Spider-Man's web fluid, mix the right ingredients and create the perfect web fluid");
    }
}

    public static void main(String[] args) throws Exception {
        WFSimulator simu = new WFSimulator();
        simu.simulation();
    }
}
