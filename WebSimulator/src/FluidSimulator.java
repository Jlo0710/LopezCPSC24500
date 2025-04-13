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

    // Method that is going to start the simulation and gather the user input
    public void simulation(){
        System.out.println("Welcome to Spider-Man's Web Fluid Simulator!");
        System.out.println("In this simulator, you will be creating Spider-Man's web fluid, mix the right ingredients and create the perfect web fluid");

        // Collects the user input for different components/chemicals of the web fluid
        System.out.print("Enter main polymer (EX: Silk Compoud, Plastic Base, Rubber Matrix): ");
        String polymer = scan.nextLine();
        System.out.print("Enter adhesive agent (EX: Bio-Adhesive, Synthetic Glue, Resin Blend: ");
        String adhesive = scan.nextLine();
        System.out.print("Enter elasticity enhancer (EX: Flexium-12, Rubber Elastic, Stretch-X): ");
        String enhancer = scan.nextLine();
        System.out.print("Enter strengthing factor (EX: Titanium Fibers, Keblar Nanotubes, Carbon Weave): ");
        String strengthener = scan.nextLine();
        System.out.print("Enter durability factor (Ex: Nano Coating, Polyurethane Shield, UV Stabilizer): ");
        String durability = scan.nextLine();
        System.out.print("Enter special property (Ex: Fire Resistance, Electric Conductivity, Magnetic Response): ");
        String specialProperty = scan.nextLine();
        System.out.print("Enter viscocity level (0-100): ");
        double viscocity = scan.nextDouble();
        System.out.print("Enter tensile strength level (0-1000): ");
        double tensileStrength = scan.nextDouble();

        FluidSimulator fluidSimulator;

        
        // Checking to see if the selected ingredients match the perfect formula for the web fluid
        if(polymer.equalsIgnoreCase("Silk Compound") && adhesive.equalsIgnoreCase("Bio-Adhesive")
        && enhancer.equalsIgnoreCase("Flexium-12") && strengthener.equalsIgnoreCase("Kevlar Molecules")
        && durability.equalsIgnoreCase("Nano Coating") && specialProperty.equalsIgnoreCase("Electric Conductivity")
        && viscocity > 75.0 && tensileStrength > 500){
            fluidSimulator = new FluidSimulator("Sticky", "High Elasticity", "Super Strong", "Long-Lasting", "Electric Conductivity", viscocity, tensileStrength);
        }else{
            // If the ingredients do not match well, assign default failed properties
            fluidSimulator = new FluidSimulator("Watery", "Brittle", "Useless", "Insatntly dissolves", "Unsatble chemical structure", viscocity, tensileStrength);
        }

        // Log the web fluid creation
        logger.log("Created web fluid with polymer: " + polymer + ", adhesive: " + adhesive + ", enhancer: " + ", strengthener: " + strengthener + ", durability: " + durability + ", special property: " + specialProperty + ", viscocity: " + viscocity + ", tensile strength: " + tensileStrength);

        // Print the logs
        logger.printLogs();
    }
}

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
